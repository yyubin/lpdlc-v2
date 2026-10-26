"""원문 → LPDL v2 컴파일 루프: 생성 → 구문/의미/완전성 검증 → 오류 피드백 재생성.

v1 NLToSQLPipeline 의 재시도 루프를 이식하되, 피드백을 구문 오류에서 의미 검증·누락 검사까지 넓혔다.
"""
from __future__ import annotations

import json
import re
import subprocess
import tempfile
from dataclasses import asdict, dataclass, field
from pathlib import Path
from typing import Protocol

from . import ast as A
from .parser import LPDLSyntaxError, parse
from .prompt import EXAMPLES, ROOT, feedback_prompt, system_prompt, user_prompt
from .validate import validate

DEFAULT_MODEL = "claude-opus-5-5"


# ── 백엔드 ───────────────────────────────────────────────────────────────────
class Conversation(Protocol):
    def send(self, text: str) -> str: ...


class Backend(Protocol):
    def start(self, system: str) -> Conversation: ...


class CompileRefused(RuntimeError):
    pass


class AnthropicBackend:
    """Anthropic API (ANTHROPIC_API_KEY 또는 `ant auth login` 프로필)."""

    def __init__(self, model: str = DEFAULT_MODEL, effort: str = "high", client=None):
        import anthropic
        self.client = client or anthropic.Anthropic()
        self.model, self.effort = model, effort
        self.usage: list[dict] = []

    def start(self, system: str) -> Conversation:
        backend = self

        class _Conv:
            def __init__(self):
                self.messages: list[dict] = []

            def send(self, text: str) -> str:
                self.messages.append({"role": "user", "content": text})
                with backend.client.beta.messages.stream(
                    model=backend.model,
                    max_tokens=64000,
                    # 시스템 프롬프트(어휘·규칙·예시)는 고정 → 캐시
                    system=[{"type": "text", "text": system, "cache_control": {"type": "ephemeral"}}],
                    messages=self.messages,
                    thinking={"type": "adaptive"},
                    output_config={"effort": backend.effort},
                    betas=["server-side-fallback-2026-07-01"],
                    fallbacks="default",
                ) as stream:
                    msg = stream.get_final_message()
                if msg.stop_reason == "refusal":
                    raise CompileRefused(f"refusal: {getattr(msg.stop_details, 'category', None)}")
                if msg.stop_reason == "max_tokens":
                    raise RuntimeError("max_tokens 도달 — 출력이 잘림")
                # thinking·fallback 블록까지 그대로 이어 붙인다 (append-only)
                self.messages.append({"role": "assistant",
                                      "content": [b.model_dump(mode="json", exclude_none=True) for b in msg.content]})
                backend.usage.append(msg.usage.model_dump(mode="json", exclude_none=True))
                return "".join(b.text for b in msg.content if b.type == "text")

        return _Conv()


class ClaudeCodeBackend:
    """Claude Code 헤드리스 (`claude -p`). API 키 없이 Claude Code 로그인으로 실행. 도구는 모두 끈다."""

    SYSTEM = "You are the LPDL v2 compiler. Follow the instructions in the first user message exactly. Output only the requested code block."

    def __init__(self, model: str | None = None, effort: str | None = None, exe: str = "claude", timeout: int = 1800):
        self.model, self.effort, self.exe, self.timeout = model, effort, exe, timeout
        self.usage: list[dict] = []

    def _run(self, prompt: str, session: str | None) -> dict:
        cmd = [self.exe, "-p", "--output-format", "json", "--tools", "", "--system-prompt", self.SYSTEM]
        if self.model:
            cmd += ["--model", self.model]
        if self.effort:
            cmd += ["--effort", self.effort]
        if session:
            cmd += ["--resume", session]
        with tempfile.TemporaryDirectory() as cwd:     # 프로젝트 CLAUDE.md 등을 읽지 않도록 빈 디렉터리에서 실행
            p = subprocess.run(cmd, input=prompt, capture_output=True, text=True, encoding="utf-8",
                               cwd=cwd, timeout=self.timeout)
        if p.returncode != 0 and not p.stdout.strip():
            raise RuntimeError(f"claude -p 실패 ({p.returncode}): {p.stderr.strip()[:500]}")
        out = json.loads(p.stdout)
        if out.get("is_error"):
            raise RuntimeError(f"claude -p 오류: {str(out.get('result'))[:500]}")
        self.usage.append({k: out.get(k) for k in ("total_cost_usd", "duration_ms", "num_turns", "usage")})
        return out

    def start(self, system: str) -> Conversation:
        backend = self

        class _Conv:
            session: str | None = None

            def send(self, text: str) -> str:
                prompt = text if self.session else f"{system}\n\n---\n\n{text}"
                out = backend._run(prompt, self.session)
                self.session = out.get("session_id")
                return out.get("result") or ""

        return _Conv()


# ── 검증 ─────────────────────────────────────────────────────────────────────
_FENCE = re.compile(r"```(?:lpdl)?[ \t]*\n(.*?)```", re.S)


def extract_lpdl(text: str) -> str:
    blocks = _FENCE.findall(text)
    if blocks:
        return max(blocks, key=len).strip() + "\n"
    return text.strip() + "\n"


def _known_keyword_docs() -> A.Document:
    from . import load
    return load([ROOT / "keywords", EXAMPLES / "keyword"])   # 표준 상태 + 예시 고유 키워드


def check(code: str, identity_id: int, outline: dict | None = None) -> tuple[A.Document | None, list[str], list[str]]:
    """(문서, 오류 목록, 검수 항목). 오류가 없으면 통과."""
    try:
        doc = parse(code)
    except LPDLSyntaxError as e:
        return None, [f"구문 오류 {e}"], []
    errors: list[str] = []
    if [i.id for i in doc.identities] != [identity_id]:
        errors.append(f"identity {identity_id} 하나만 있어야 함 (출력: {[i.id for i in doc.identities]})")
    known = _known_keyword_docs()
    known_names = {k.name for k in known.keywords}
    for k in doc.keywords:
        if k.name in known_names:
            errors.append(f'keyword "{k.name}": 이미 정의된 키워드 — 다시 선언하지 말 것')
    merged = A.Document(identities=doc.identities,
                        keywords=known.keywords + [k for k in doc.keywords if k.name not in known_names])
    rep = validate(merged)
    errors += [str(i) for i in rep.errors]
    review = [str(i) for i in rep.of("review") if "identity" in i.where or any(
        f'keyword "{k.name}"' in i.where for k in doc.keywords)]
    if outline and doc.identities:
        errors += completeness(doc.identities[0], outline)
    return doc, errors, review


def completeness(ident: A.Identity, outline: dict) -> list[str]:
    errs = []
    have = {(s.ref.slot, s.ref.variant): s for s in ident.skills}
    for (slot, var), coins in outline["skills"].items():
        name = f"skill {slot}" + (f" variant {var}" if var else "")
        s = have.get((slot, var))
        if s is None:
            errs.append(f"누락: {name}")
            continue
        got = {c.index for c in s.coins if c.blocks or c.flags}
        for c in coins:
            if c not in got:
                errs.append(f"누락: {name} coin {c} (원문에 코인 효과 있음)")
    for key in have:
        if key not in outline["skills"]:
            errs.append(f"원문에 없는 스킬: {key[0]} variant {key[1]}")
    names = {(p.name, p.support) for p in ident.passives}
    for name, support in outline["passives"]:
        if (name, support) not in names:
            errs.append(f'누락: {"support" if support else "passive"} "{name}"')
    return errs


# ── 루프 ─────────────────────────────────────────────────────────────────────
@dataclass
class Attempt:
    n: int
    errors: list[str]
    code: str


@dataclass
class CompileResult:
    identity_id: int
    ok: bool
    code: str
    review: list[str] = field(default_factory=list)
    attempts: list[Attempt] = field(default_factory=list)

    def summary(self) -> dict:
        d = asdict(self)
        d["attempts"] = [{"n": a.n, "errors": a.errors} for a in self.attempts]
        d.pop("code")
        return d


def compile_identity(source: str, identity_id: int, backend: Backend, outline: dict | None = None,
                     max_attempts: int = 3, examples=(202,)) -> CompileResult:
    conv = backend.start(system_prompt(examples))
    msg = user_prompt(source)
    result = CompileResult(identity_id, ok=False, code="")
    for n in range(1, max_attempts + 1):
        code = extract_lpdl(conv.send(msg))
        _, errors, review = check(code, identity_id, outline)
        result.attempts.append(Attempt(n, errors, code))
        result.code, result.review = code, review
        if not errors:
            result.ok = True
            break
        msg = feedback_prompt(errors[:40])
    return result
