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
