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
    "use": "[사용시] (스킬 사용 = 합 또는 일방 공격 직전)",
    "before_attack": "[공격 시작 전] (합 승리 후 또는 일방 공격, 공격 직전. 합 패배 시 없음)",
    "clash_start": "[합 진행 시]",
    "clash_win": "[합 승리시]",
    "clash_lose": "[합 패배시]",
    "coin_start": "[코인 시작 시] (공격할 때 코인마다 토스 직전, 코인당 1회. 합 중에는 발생하지 않음)",
    "coin_flip": "[코인 판정 시] (출혈의 발동 시점. 원문에 이 태그를 쓰는 스킬·패시브는 없음)",
    "hit": "[적중시]",
    "head_hit": "[앞면 적중시]",
    "tail_hit": "[뒷면 적중시]",
    "crit": "[치명타 적중시]",
    "head": "[앞면]",
    "tail": "[뒷면]",
    "attack_end": "[공격 종료시]",
    "combat_end": "전투 종료 시 (턴의 전투 단계 종료)",
    "kill": "[처치시]",
    "hit_taken": "피격 시",
    "stagger": "흐트러짐 시",
    "dead": "사망 시",
    "turn_end": "턴 종료 시",
    "ally_attack": "아군이 공격 시",
    "ally_hit": "아군 적중 시",
    "ally_dead": "아군 사망 시",
    "ally_hit_taken": "아군 피격 시 (target = 피격된 아군, attacker = 공격자)",
    "ally_before_attack": "아군 [공격 시작 전] (target = 그 아군)",
    "ally_attack_end": "아군 [공격 종료시] (target = 그 아군)",
    # 자원·상태 이벤트 (args 에 대상 키워드/자원)
    "burst": "(진동 등) 폭발 시          on burst(진동)",
    "gained": "자원 획득 시              on gained(self.보존.count)",
    "consumed": "자원 소모 시              on consumed(self.보존.count) every 10",
    "applied": "상태 부여 시              on applied(진동)",
}
COIN_EVENTS = {"coin_start", "coin_flip", "hit", "head_hit", "tail_hit", "crit", "head", "tail", "clash_win", "clash_lose"}
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
    "crit_chance": "치명타 확률 (%p)",
    "amount": "이벤트 수량 (gained/consumed/applied 안에서만)",
}

DAMAGE_TYPES = {"slash", "pierce", "blunt", "fixed", "stagger", "sanity"}
# 죄악 속성 피해 ("나태 피해") — deal target 나태 X

# 유닛 필드 (self.X / target.X)
UNIT_FIELDS = {"hp", "max_hp", "hp_ratio", "shield", "sanity", "has_sanity", "speed", "stagger_gauge", "level", "formation"}
# has_sanity: 정신력이 있는 유닛이면 1 (정신력 없는 적은 0)
UNIT_ROOTS = {"self", "target", "attacker", "it"}
GROUP_ROOTS = {"allies", "enemies"}
SPECIAL_ROOTS = {
    "ev": {"amount", "source", "overflow"},    # overflow = 획득량 중 최대치 초과분
    "coin": {"final_damage", "power", "index", "is_head"},
    "skill": set(),                 # skill is basic_attack
    "team": {"max_resonance", "absolute_resonance"},   # 최대 공명 수, 절대 공명 수
}
STATUS_FIELDS = {"potency", "count"}

# `x is C` 의 C
CATEGORIES = {"basic_attack", "basic_skill", "attack", "defense", "ego", "counter", "evade", "guard",
              "ally", "enemy", "main_target",
              "slash", "pierce", "blunt"}                   # 공격 유형: skill is slash         # 유닛 분류: target is ally / it is main_target

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
    "has_affiliation": (2, 2, set()),   # has_affiliation(it, "르누아르")   "르누아르 소속"
    "keyword_identity": (2, 2, set()),  # keyword_identity(it, 충전)        "충전 인격" (인격 키워드 분류)
    # pick(allies, where: it != self, prefer: keyword_identity(it, 충전), by: it.hp_ratio, n: 1)
    #   by = 정렬 기준 식 (오름차순, desc: 1 이면 내림차순), prefer = 먼저 고를 조건
    "pick": (1, 1, {"where", "by", "n", "desc", "prefer"}),
}

FLAGS = {"clashable_counter", "unbreakable", "reuse", "aoe", "unclashable", "fixed_target", "ally_target"}   # unclashable=[합 불가능], fixed_target=[대상 변경 불가], ally_target=아군 지정 가능 (양극성)

KEYWORD_KINDS = {"status", "charge", "special_charge", "value"}
KEYWORD_PROPS = {"kind", "max", "count_max", "potency_max", "inherit"}

SINS = ("분노", "색욕", "나태", "탐식", "우울", "오만", "질투")

SLOTS = ("S1", "S2", "S3", "DEF", "EGO")


@lru_cache(maxsize=1)
def registry_keywords() -> frozenset[str]:
    """게임 키워드 사전(gesellschaft keyword 테이블에서 이름만 추출)."""
    data = json.loads(Path(__file__).with_name("data").joinpath("keywords.json").read_text(encoding="utf-8"))
    return frozenset(k["name"] for k in data["keywords"])
