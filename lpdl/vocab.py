"""LPDL v2 고정 어휘. 문법은 이름을 NAME으로만 받고, 여기 있는 것만 검증기를 통과한다.

v1(LPDL.g4)은 trigger/stat/unit을 모두 IDENT로 받아 아무 이름이나 통과했다 → v2는 이 목록이 유일한 기준.
"""
import json
from functools import lru_cache
from pathlib import Path

# 이벤트 → 게임 텍스트 태그
EVENTS = {
    "stage_enter": "전장에 등장 시",
    "turn_start": "턴 시작 시",
    "combat_start": "[전투 시작시]",
    "before_use": "[사용전]",
    "use": "[사용시]",
    "before_attack": "[공격 시작 전]",
    "clash_start": "[합 진행 시]",
    "clash_win": "[합 승리시]",
    "clash_lose": "[합 패배시]",
    "coin_flip": "[코인 판정 시]",
    "hit": "[적중시]",
    "head_hit": "[앞면 적중시]",
    "tail_hit": "[뒷면 적중시]",
    "crit": "[치명타 적중시]",
    "head": "[앞면]",
    "tail": "[뒷면]",
    "attack_end": "[공격 종료시]",
    "kill": "[처치시]",
    "hit_taken": "피격 시",
    "stagger": "흐트러짐 시",
    "dead": "사망 시",
    "turn_end": "턴 종료 시",
    "ally_attack": "아군이 공격 시",
    "ally_hit": "아군 적중 시",
    "ally_dead": "아군 사망 시",
    # 자원·상태 이벤트 (args 에 대상 키워드/자원)
    "burst": "(진동 등) 폭발 시          on burst(진동)",
    "gained": "자원 획득 시              on gained(self.보존.count)",
    "consumed": "자원 소모 시              on consumed(self.보존.count) every 10",
    "applied": "상태 부여 시              on applied(진동)",
}
COIN_EVENTS = {"coin_flip", "hit", "head_hit", "tail_hit", "crit", "head", "tail", "clash_win", "clash_lose"}
RESOURCE_EVENTS = {"gained", "consumed", "applied", "burst"}   # ev.amount 를 가짐

# modify 대상. 피해 공식(gesellschaft docs/rules/00-core-rules.md)의 위치를 이름으로 구분한다.
MODIFY_TARGETS = {
    "base_power": "기본 위력 (스킬 위력)",
    "coin_power": "코인 위력",
    "clash_power": "합 위력 (합에서만)",
    "final_power": "최종 위력",
    "damage_pct": "피해량 +X% (셋째 괄호)",
    "damage_flat": "고정 피해 증감",
    "taken_damage_pct": "받는 피해량 +X%",
    "stagger_damage_pct": "흐트러짐 피해량 +X%",
    "atk_level": "공격 레벨",
    "def_level": "방어 레벨",
    "speed_min": "속도 최솟값",
    "speed_max": "속도 최댓값",
    "taunt": "도발치",
    "heads_prob": "앞면 확률 (%p)",
    "amount": "이벤트 수량 (gained/consumed/applied 안에서만)",
}

DAMAGE_TYPES = {"slash", "pierce", "blunt", "fixed", "stagger", "sanity"}

# 유닛 필드 (self.X / target.X)
UNIT_FIELDS = {"hp", "max_hp", "shield", "sanity", "speed", "stagger_gauge", "level", "formation"}
UNIT_ROOTS = {"self", "target", "attacker", "it"}
GROUP_ROOTS = {"allies", "enemies"}
SPECIAL_ROOTS = {
    "ev": {"amount", "source"},
    "coin": {"final_damage", "power", "index", "is_head"},
    "skill": set(),                 # skill is basic_attack
}
STATUS_FIELDS = {"potency", "count"}

# `x is C` 의 C
CATEGORIES = {"basic_attack", "basic_skill", "attack", "defense", "ego", "counter", "evade", "guard"}

# 함수: 이름 → (최소 인자 수, 최대 인자 수, 허용 kwargs)
FUNCS = {
    "min": (2, 9, set()),
    "max": (2, 9, set()),
    "floor": (1, 1, set()),
    "ceil": (1, 1, set()),
    "per": (2, 2, set()),           # per(x, n) = floor(x / n)  "X n당"
    "pct": (2, 2, set()),           # pct(x, p) = x * p / 100   "X의 p%"
    "has": (2, 2, set()),           # has(unit, 키워드)
    "has_kind": (2, 2, set()),      # has_kind(unit, special_charge)
    "count_of": (2, 2, set()),      # count_of(allies, where-식)
    "pick": (1, 1, {"where", "by", "n", "desc"}),   # pick(allies, where: has(it, 충전), by: formation, n: 1)
}

FLAGS = {"clashable_counter", "unbreakable", "reuse", "aoe", "unclashable", "fixed_target"}   # unclashable=[합 불가능], fixed_target=[대상 변경 불가]

KEYWORD_KINDS = {"status", "charge", "special_charge", "value"}
KEYWORD_PROPS = {"kind", "max", "count_max", "potency_max", "inherit"}

SINS = ("분노", "색욕", "나태", "탐식", "우울", "오만", "질투")

SLOTS = ("S1", "S2", "S3", "DEF", "EGO")


@lru_cache(maxsize=1)
def registry_keywords() -> frozenset[str]:
    """게임 키워드 사전(gesellschaft keyword 테이블에서 이름만 추출)."""
    data = json.loads(Path(__file__).with_name("data").joinpath("keywords.json").read_text(encoding="utf-8"))
    return frozenset(k["name"] for k in data["keywords"])
