from pathlib import Path

from lpdl import load, validate
from lpdl.ast import Document

EXAMPLES = Path(__file__).parents[1] / "examples"


def test_examples_validate_clean():
    rep = validate(load([EXAMPLES]))
    assert rep.errors == [], "\n".join(map(str, rep.errors))
    assert not rep.of("warning")


def test_202_structure():
    i = next(x for x in load([EXAMPLES]).identities if x.id == 202)
    assert [(s.ref.slot, s.ref.variant) for s in i.skills] == [("S1", 0), ("S2", 0), ("S3", 0), ("S3", 1), ("DEF", 0)]
    assert [len(s.coins) for s in i.skills] == [2, 3, 3, 4, 2]
    assert [p.name for p in i.passives] == ["되먹임", "르누아르 개버딘 원단", "보존", "르누아르의 미덕과 가치"]
    assert i.passives[0].requires.sins == ["나태", "오만", "질투"]
    assert i.passives[3].support


def test_ast_roundtrips_through_json():
    doc = load([EXAMPLES])
    assert Document.model_validate_json(doc.model_dump_json()) == doc


def test_202_s3_coin3_separate_hit_lines_all_fire():
    """R1: 줄이 다른 [적중시]는 독립 효과 → 무조건 1회 블록 + 조건부 2회 블록이 순서대로 존재."""
    i = next(x for x in load([EXAMPLES]).identities if x.id == 202)
    s3 = next(s for s in i.skills if s.ref.slot == "S3" and s.ref.variant == 0)
    hits = [b for b in s3.coins[2].blocks if getattr(b, "event", None) == "hit"]
    assert [b.when is None for b in hits] == [True, False]
    assert [b.body[0].times for b in hits][0] is None and hits[1].body[0].times.value == 2


def test_coat_gain_is_self_sourced():
    """R2: '자신의 스킬, 패시브 효과로' → by self."""
    coat = next(k for k in load([EXAMPLES]).keywords if k.name == "르누아르 개버딘 원단 코트")
    res = [b for b in coat.blocks if getattr(b, "event", None) in ("gained", "consumed")
           and b.args[0].path == ["self", "보존", "count"]]
    assert len(res) == 2 and all(b.by.path == ["self"] for b in res)
