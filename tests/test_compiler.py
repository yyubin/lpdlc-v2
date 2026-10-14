"""컴파일 루프 테스트 — 네트워크 없이 가짜 백엔드로."""
from pathlib import Path

from lpdl.compiler import check, compile_identity, completeness, extract_lpdl
from lpdl.parser import parse
from lpdl.prompt import system_prompt, user_prompt

EX = Path(__file__).parents[1] / "examples"
REF_202 = (EX / "identity" / "202.lpdl").read_text(encoding="utf-8")
OUTLINE_202 = {
    "skills": {("S1", 0): [1, 2], ("S2", 0): [1, 2, 3], ("S3", 0): [1, 2, 3], ("S3", 1): [1, 2, 3, 4], ("DEF", 0): [2]},
    "passives": [("되먹임", False), ("르누아르 개버딘 원단", False), ("보존", False), ("르누아르의 미덕과 가치", True)],
}


class FakeBackend:
    def __init__(self, replies):
        self.replies, self.sent, self.system = list(replies), [], None

    def start(self, system):
        self.system = system
        fake = self

        class _Conv:
            def send(self, text):
                fake.sent.append(text)
                return fake.replies.pop(0)

        return _Conv()


def fenced(code: str) -> str:
    return f"설명은 무시됨\n```lpdl\n{code}\n```\n"


def test_extract_takes_fenced_block():
    assert extract_lpdl("앞\n```lpdl\nlpdl 2\n```\n뒤") == "lpdl 2\n"
    assert extract_lpdl("lpdl 2") == "lpdl 2\n"


def test_reference_passes_check_and_completeness():
    doc, errors, _ = check(REF_202, 202, OUTLINE_202)
    assert errors == []


def test_completeness_reports_missing_parts():
    ident = parse("lpdl 2\nidentity 202 { skill S1 { coin 1 { on hit { apply target 진동 potency 2 } } } }").identities[0]
    errs = completeness(ident, OUTLINE_202)
    assert "누락: skill S1 coin 2 (원문에 코인 효과 있음)" in errs
    assert "누락: skill S3 variant 1" in errs
    assert '누락: support "르누아르의 미덕과 가치"' in errs


def test_redeclaring_known_keyword_is_error():
    _, errors, _ = check('lpdl 2\nkeyword "보존" { prop kind special_charge }\nidentity 1 { }', 1)
    assert any("이미 정의된 키워드" in e for e in errors)


def test_wrong_identity_id_is_error():
    _, errors, _ = check("lpdl 2\nidentity 5 { }", 1)
    assert any("identity 1 하나만" in e for e in errors)


def test_loop_feeds_errors_back_until_valid():
    bad = "lpdl 2\nidentity 202 { skill S1 { on hitt { apply target 진동 potency 2 } } }"
    fb = FakeBackend([fenced(bad), "```lpdl\nlpdl 2\nidentity 202 {\n```", fenced(REF_202)])
    r = compile_identity("원문", 202, fb, outline=OUTLINE_202, max_attempts=3)
    assert r.ok and len(r.attempts) == 3
    assert "알 수 없는 이벤트" in fb.sent[1] and "head_hit" not in fb.sent[0]
    assert "구문 오류" in fb.sent[2]
    assert r.code == REF_202.strip() + "\n"


def test_loop_gives_up_after_max_attempts():
    bad = fenced("lpdl 2\nidentity 202 { }")
    r = compile_identity("원문", 202, FakeBackend([bad, bad]), outline=OUTLINE_202, max_attempts=2)
    assert not r.ok and len(r.attempts) == 2 and r.attempts[-1].errors


def test_system_prompt_contains_vocab_rules_and_example():
    s = system_prompt()
    for needle in ("head_hit: [앞면 적중시]", "stagger_damage_pct", "R1.", "R5.", "# 예시: identity 202",
                   'keyword "보존"', "identity 202 \"오트쿠튀르::르누아르 신발관\""):
        assert needle in s, needle
    assert user_prompt("원문 X").endswith("원문 X\n")
