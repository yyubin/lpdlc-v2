"""python -m lpdl check <파일|디렉터리>...
python -m lpdl compile <identity id>... [--backend claude-code|api]"""
import argparse
import json
import sys
from pathlib import Path

from . import LPDLSyntaxError, load, validate


def main(argv=None) -> int:
    ap = argparse.ArgumentParser(prog="lpdl")
    sub = ap.add_subparsers(dest="cmd", required=True)
    c = sub.add_parser("check", help="구문 + 의미 검증")
    c.add_argument("paths", nargs="+")
    c.add_argument("--review", action="store_true", help="검수 항목(note/unparsed/hook)도 출력")
    k = sub.add_parser("compile", help="원문(gesellschaft DB) → LPDL (Claude)")
    k.add_argument("ids", nargs="+", type=int)
    k.add_argument("--db", default=None, help="gesellschaft.db 경로 (기본: ../gesellschaft/data/gesellschaft.db)")
    k.add_argument("--backend", choices=["claude-code", "api"], default="claude-code")
    k.add_argument("--model", default=None, help="api 기본 claude-opus-5-5, claude-code 기본은 CLI 설정")
    k.add_argument("--effort", default="high")
    k.add_argument("--max-attempts", type=int, default=3)
    k.add_argument("--out", default="compiled")
    a = ap.parse_args(argv)
    if a.cmd == "compile":
        return _compile(a)

    try:
        doc = load(a.paths)
    except LPDLSyntaxError as e:
        print(f"[syntax] {e}")
        return 2
    rep = validate(doc)
    for i in rep.issues:
        if i.level != "review" or a.review:
            print(i)
    n = {lv: len(rep.of(lv)) for lv in ("error", "warning", "review")}
    print(f"identity {len(doc.identities)} · keyword {len(doc.keywords)} — "
          f"error {n['error']} · warning {n['warning']} · review {n['review']}")
    return 0 if rep.ok else 1


def _compile(a) -> int:
    from .compiler import DEFAULT_MODEL, AnthropicBackend, ClaudeCodeBackend, compile_identity
    from .source import DEFAULT_DB, identity_outline, render_identity

    db = a.db or DEFAULT_DB
    if a.backend == "api":
        backend = AnthropicBackend(model=a.model or DEFAULT_MODEL, effort=a.effort)
    else:
        backend = ClaudeCodeBackend(model=a.model, effort=a.effort)
    out = Path(a.out) / "identity"
    out.mkdir(parents=True, exist_ok=True)
    failed = 0
    for i in a.ids:
        backend.usage = []
        r = compile_identity(render_identity(db, i), i, backend, outline=identity_outline(db, i),
                             max_attempts=a.max_attempts)
        (out / f"{i}.lpdl").write_text(r.code, encoding="utf-8")
        summary = {**r.summary(), "backend": a.backend, "usage": backend.usage}
        (out / f"{i}.report.json").write_text(json.dumps(summary, ensure_ascii=False, indent=2), encoding="utf-8")
        errs = len(r.attempts[-1].errors)
        print(f"identity {i}: {'OK' if r.ok else 'FAIL'} — 시도 {len(r.attempts)} · 남은 오류 {errs} · 검수 {len(r.review)}"
              f" → {out / f'{i}.lpdl'}")
        failed += not r.ok
    return 1 if failed else 0


if __name__ == "__main__":
    sys.exit(main())
