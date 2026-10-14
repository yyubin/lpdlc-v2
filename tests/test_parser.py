import pytest

from lpdl import LPDLSyntaxError, ast as A, parse


def one_skill(body: str) -> A.Skill:
    return parse(f"lpdl 2\nidentity 1 {{\n skill S1 {{\n{body}\n }}\n}}").identities[0].skills[0]


def test_header_and_names():
    d = parse('lpdl 2\nidentity 202 "신발관" { use 코트 = "르누아르 개버딘 원단 코트" }')
    assert d.version == 2
    i = d.identities[0]
    assert (i.id, i.name, i.uses) == (202, "신발관", {"코트": "르누아르 개버딘 원단 코트"})


def test_on_block_options():
    b = one_skill("on hit_taken when self.shield > 0 limit 2/turn/target { apply attacker 진동 potency 2 }").blocks[0]
    assert b.event == "hit_taken"
    assert (b.limit.times, b.limit.period, b.limit.per_target) == (2, "turn", True)
    assert isinstance(b.when, A.BinOp) and b.when.op == ">"
    st = b.body[0]
    assert isinstance(st, A.Apply) and st.keyword == "진동" and st.potency.value == 2 and st.count is None


def test_potency_and_count_are_separate():
    """v1 예제 6은 '파열 횟수 1'을 위력 +1로 바꿨다. v2는 둘을 다른 필드로 둔다."""
    body = one_skill("on hit { apply target 파열 potency 2 count 1 \n gain target.파열.count 1 }").blocks[0].body
    assert body[0].potency.value == 2 and body[0].count.value == 1
    assert body[1].ref.path == ["target", "파열", "count"]


def test_consume_modes_and_bind():
    body = one_skill("on use { consume self.보존.count up_to 20 -> n \n consume self.보존.count all \n"
                     " consume self.보존.count 6 }").blocks[0].body
    assert [(c.mode, c.bind) for c in body] == [("up_to", "n"), ("all", None), ("exact", None)]


def test_modify_cap_and_precedence():
    m = one_skill("on use { modify damage_pct 1 + n * 3 cap 45 }").blocks[0].body[0]
    assert m.target == "damage_pct" and m.opts.cap.value == 45
    assert m.amount.op == "+" and m.amount.right.op == "*"


def test_when_elif_else():
    w = one_skill('on use { when a >= 5 { modify coin_power 2 } elif a >= 3 { modify coin_power 1 } '
                  'else { note "x" } }').blocks[0].body[0]
    assert len(w.branches) == 2 and isinstance(w.otherwise[0], A.Note)


def test_skill_variant_replace_and_is():
    s = parse("lpdl 2\nidentity 1 { skill S3 variant 1 { on use when skill is S3 or skill is basic_attack "
              "{ replace this -> S3 variant 1 this_turn } } }").identities[0].skills[0]
    assert (s.ref.slot, s.ref.variant) == ("S3", 1)
    r = s.blocks[0].body[0]
    assert r.source is None and (r.dest.slot, r.dest.variant) == ("S3", 1) and r.opts.this_turn
    assert s.blocks[0].when.left.category.slot == "S3"


def test_call_kwargs_and_negative_numbers():
    b = one_skill("on use { gain self.보존.count -1 \n"
                  " let a = pick(allies, where: has(it, 충전), by: formation, n: 1) }").blocks[0]
    assert b.body[0].amount.value == -1
    call = b.body[1].value
    assert call.func == "pick" and set(call.kwargs) == {"where", "by", "n"}


def test_triple_string_text_and_comments():
    s = one_skill('# 주석\n text """\n   [적중시] 진동 2 부여\n """\n coin 1 { on hit { burst target 진동 times 2 } }')
    assert s.texts == ["[적중시] 진동 2 부여"]
    assert s.coins[0].blocks[0].body[0].times.value == 2


def test_apply_needs_potency_or_count():
    with pytest.raises(LPDLSyntaxError) as e:
        parse("lpdl 2\nidentity 1 {\n skill S1 { on hit { apply target 진동 } }\n}")
    assert e.value.line == 3
