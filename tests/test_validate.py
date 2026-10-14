import pytest

from lpdl import parse, validate


def errors(src: str) -> list[str]:
    return [i.message for i in validate(parse("lpdl 2\n" + src)).errors]


def skill(body: str) -> str:
    return f"identity 1 {{ skill S1 {{ {body} }} }}"


def test_valid_minimal():
    assert errors(skill("on hit { apply target 진동 potency 2 }")) == []


@pytest.mark.parametrize("body, needle", [
    ("on hitt { apply target 진동 potency 2 }", "알 수 없는 이벤트"),       # v1: trigger 가 IDENT 라 통과했음
    ("on hit { apply target 진동동 potency 2 }", "알 수 없는 키워드"),
    ("on use { modify dmg_pct 10 }", "알 수 없는 대상"),
    ("on use { modify amount 1 }", "modify amount"),
    ("on use { gain self.없는것.count 2 }", "유닛 필드도 키워드도 아님"),
    ("on use { gain self.보존.cnt 2 }", "potency / count"),
    ("on use { gain n 2 }", "알 수 없는 이름"),
    ("on use { modify damage_pct foo(1) }", "알 수 없는 함수"),
    ("on use when skill is basic_atack { modify coin_power 1 }", "알 수 없는 분류"),
    ("on use { modify coin_power ev.amount }", "ev 는"),
    ("on use { modify coin_power coin.power }", "coin.*"),
    ("on use every 10 { modify coin_power 1 }", "every"),
    ("coin 1 { on turn_end { modify coin_power 1 } }", "코인 블록"),
    ("on use { gain self.shield 1 budget 없는예산 }", "budget"),
    ("on use { deal target fire 10 }", "deal fire"),
    ("on use { gain self.shield 1 next_turn this_turn }", "함께"),
    ("flag shiny", "flag"),
    ("on burst { modify stagger_damage_pct 10 }", "대상 자원/키워드"),
    ("on hit(진동) { modify coin_power 1 }", "인자를 받지 않는"),
])
def test_rejects(body, needle):
    msgs = errors(skill(body))
    assert any(needle in m for m in msgs), msgs


def test_suggestion():
    msgs = errors(skill("on head_hitt { apply target 진동 potency 2 }"))
    assert "head_hit" in msgs[0]


def test_duplicate_skill_and_coin():
    assert any("중복" in m for m in errors("identity 1 { skill S1 { } skill S1 { } }"))
    assert any("중복" in m for m in errors(skill("coin 1 { } coin 1 { }")))


def test_declared_status_keyword_requires_field():
    src = 'keyword "보존" { prop kind special_charge }\n' + skill("on use { gain self.보존 2 }")
    assert any("potency 또는 .count" in m for m in errors(src))


def test_value_keyword_rejects_field():
    src = ('keyword "르누아르 개버딘 원단 코트" { prop kind value }\n'
           'identity 1 { use 코트 = "르누아르 개버딘 원단 코트" skill S1 { on use { gain self.코트.count 2 } } }')
    assert any("수치형" in m for m in errors(src))


def test_unknown_use_target():
    assert any("알 수 없는 키워드" in m for m in errors('identity 1 { use x = "없는 키워드" }'))


def test_locals_from_let_and_bind():
    assert errors(skill("on use { consume self.보존.count up_to 20 -> n \n let k = per(n, 5) \n"
                        " modify damage_pct k cap 20 }")) == []


def test_local_is_block_scoped():
    """when 안에서 만든 지역 변수는 밖에서 보이지 않는다."""
    src = skill("on use { when self.hp > 0 { let k = 1 } \n modify coin_power k }")
    assert any("알 수 없는 이름" in m for m in errors(src))


def test_it_only_inside_pick():
    assert any("it 은" in m for m in errors(skill("on use when has(it, 충전) { modify coin_power 1 }")))
    assert errors(skill("on use when count_of(allies, has(it, 충전)) >= 2 { modify coin_power 1 }")) == []


def test_requires_sins():
    src = 'identity 1 { passive "p" { requires hold [나태, 탐욕] 2 } }'
    assert any("죄악" in m for m in errors(src))


def test_notes_are_review_items_not_errors():
    rep = validate(parse("lpdl 2\n" + skill('on use { note "확인 필요" \n unparsed """원문""" reason "모름" }')))
    assert rep.ok and len(rep.of("review")) == 2


# ── 어휘 확장 (첫 컴파일 결과 반영) ──
def test_extended_vocab_is_valid():
    src = skill(
        'on use when target is ally { modify coin_power 1 } '
        'on use { let a = pick(allies, where: it != self and has_affiliation(it, "르누아르"), '
        'prefer: keyword_identity(it, 충전), by: it.hp_ratio, n: 1) \n apply a 진동 potency 1 } '
        'on use { modify final_power per(team.max_resonance, 1) cap 4 coins last } '
        'always { modify def_level 2 to pick(allies, where: has_affiliation(it, "르누아르")) } '
        'coin 1 { on hit limit 1/use { reuse_coin } on hit { deal target 나태 pct(coin.final_damage, 10) '
        '\n use_skill S1 variant 1 on target \n retype target 진동 -> 진동 } } '
        'on ally_hit_taken when target.shield > 0 { gain self.충전.count 1 } '
        'on combat_end { gain self.shield 1 }'
    )
    assert errors(src) == []


@pytest.mark.parametrize("body, needle", [
    ("on use { reuse_coin }", "reuse_coin"),
    ('on use when has_affiliation(target, 르누아르) { modify coin_power 1 }', "소속 이름 문자열"),
    ("on use when keyword_identity(target, 없는것) { modify coin_power 1 }", "알 수 없는 키워드"),
    ("on use { deal target 탐욕 3 }", "죄악 이름"),
    ("on use { modify coin_power team.resonance }", "알 수 없는 필드"),
])
def test_extended_vocab_rejects(body, needle):
    msgs = errors(skill(body))
    assert any(needle in m for m in msgs), msgs


def test_local_unit_fields():
    """let a = pick(...) 로 고른 유닛의 필드·키워드 참조."""
    assert errors(skill("on use { let a = pick(allies, by: it.hp_ratio, n: 1) \n gain a.shield 10 \n"
                        " gain a.충전.count 2 }")) == []
    assert any("유닛 필드도 키워드도 아님" in m for m in errors(skill("on use { let a = 1 \n gain a.없음 1 }")))
