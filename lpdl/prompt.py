"""컴파일 프롬프트: 원문 → LPDL v2.

시스템 프롬프트는 고정(캐시 대상)이고, 대상 인격 원문만 user 메시지로 바뀐다.
v1 PromptTemplate 과 달리 어휘 목록은 vocab.py 에서 생성하고, few-shot 은 검증 통과한 예시만 쓴다.
"""
from __future__ import annotations

from pathlib import Path
from string import Template

from . import vocab as V

ROOT = Path(__file__).resolve().parents[1]
EXAMPLES = ROOT / "examples"

LANGUAGE = """\
# LPDL v2 언어 요약

LPDL 은 효과(메커니즘)만 기술한다. 체력·위력·코인 수 같은 스탯은 쓰지 않는다 (DB에 있음).

## 구조
lpdl 2
keyword "이름" { prop kind status|charge|special_charge|value  prop max N  prop count_max N  prop inherit "키워드"  블록... }
identity <id> "이름" {
  use 별칭 = "공백 있는 키워드 정식 이름"
  budget 이름 N/turn                      # 여러 효과가 공유하는 턴당 상한
  skill S1|S2|S3|DEF|EGO [variant N] "스킬 이름" { flag ...  블록...  coin N { flag ...  블록... } }
  passive "이름" { requires hold|resonate [죄악, ...] N  블록... }
  support "이름" { requires ...  블록... }
}

## 블록
on <event>[(인자)] [when 조건] [limit N/turn|battle|use[/target]] [by 유닛식] [every N] { 문장... }
always { 문장... }                       # 태그 없는 상시 효과 (스킬·코인·패시브 범위 안에서)

## 문장
text \"\"\"원문\"\"\"                          # 원문 줄 (선택)
note "해석 메모"                           # 원문이 애매해서 해석을 고른 경우 반드시 남긴다
unparsed \"\"\"원문\"\"\" reason "이유"        # 표현할 수 없는 문장. 지어내지 말고 이걸 쓴다
hook 이름(인자...)                         # 엔진 Python 구현이 필요한 특수 효과 (snake_case 영문 이름)
let 이름 = 식
gain <참조> 식 [옵션]                       # 증감 (음수 = 감소). 예: gain self.보존.count 2, gain self.shield pct(self.max_hp, 5)
apply <대상식> <키워드> potency 식 [count 식] [옵션]   # 상태 "부여"
consume <참조> N | up_to N | all [-> 변수] [옵션]     # N=부족하면 소모 안 함(결과 0), up_to=있는 만큼
modify <대상> 식 [옵션]                     # 공식 항 수정 (아래 목록)
burst <대상식> <키워드> [times 식]          # 진동 폭발 등
deal <대상식> <피해유형> 식                  # 추가 피해
replace this|<슬롯> [variant N] -> <슬롯> [variant N] [옵션]   # "~로 발동됨", "~로 적용됨"
convert <참조> -> <참조> [옵션]             # 키워드 전환
when 조건 { ... } elif 조건 { ... } else { ... }      # "대신" = else
defer <event> { ... }                      # 이번 사용 중 나중 시점 ("이 효과가 발동했으면 공격 종료 시 ...")
reuse_coin [times 식]                      # "이 코인 재사용" (코인 블록 안에서만, 횟수 제한은 블록 limit)
use_skill <슬롯> [variant N] [on 대상식]    # 다른 스킬을 추가로 발동 ("~ 발동", 추가 공격)
retype <대상식> <키워드> -> <키워드>         # 상태 유형 변경, 위력·횟수 유지 ("진동 - 보존으로 진폭 변환")
옵션: cap 식 | next_turn | this_turn | coins all|first|last|current|N | budget 이름 | to 대상식
      to = 오라: 이 효과를 다른 유닛(들)에게 적용. 예) always { modify def_level 2 to pick(allies, where: has_affiliation(it, "르누아르")) }

## 참조와 식
유닛: self target attacker it(pick/count_of 안에서만)
유닛 필드: ${unit_fields}
키워드: self.<키워드>.potency / .count (status·charge 계열), self.<키워드> (value 계열). 공백 있는 이름은 use 별칭
이벤트 값: ev.amount ev.source ev.overflow(획득량 중 최대치 초과분) (gained/consumed/applied/burst 안에서만)
팀: team.max_resonance (최대 공명 수), team.absolute_resonance
코인: coin.final_damage coin.power coin.index coin.is_head (코인 블록 안에서만)
분류: skill is <분류> | skill is S3 [variant 1] | target is ally | target is enemy | it is main_target
유닛 비교: it != self, target == self
그룹: allies enemies → pick(allies, where: 조건, prefer: 우선 조건, by: 정렬식, n: 1, desc: 1), count_of(allies, 조건)
      pick 은 by 오름차순 정렬(desc: 1 이면 내림차순), prefer 를 만족하는 유닛을 먼저 고른다. n: 1 이면 유닛 하나, 아니면 목록
연산: + - * / >= <= == != > < and or not, 괄호, 숫자, "문자열", [목록]
함수: ${funcs}

## 고정 어휘 (이 목록 밖의 이름은 검증 오류)
event (이름: 원문 태그):
${events}
코인 블록에서 쓸 수 있는 event: ${coin_events}
modify 대상 (이름: 의미):
${modify}
피해 유형: ${damage}, 또는 죄악 이름(분노 색욕 나태 탐식 우울 오만 질투) = 그 속성 피해
분류(is): ${categories}
flag: ${flags}
죄악: ${sins}
"""

RULES = """\
# 원문 해석 규칙 (확정)

R1. 줄이 다른 같은 태그([적중시] 등)는 독립된 효과이고, 적힌 순서대로 모두 발동한다. 줄마다 별도 on 블록을 쓰고
    순서를 유지한다. 조건이 붙은 줄도 앞 줄을 대체하지 않는다. 한 태그 문단 안의 "-" 하위 항목은 하나의 효과다.
R2. "자신의 ~ 효과로"는 자기 자신이 원인인 효과만(스킬·패시브 모두) → by self. 아군 지원 효과로 받은 것은 제외.
R3. "스킬, 패시브"처럼 나열된 출처를 문자 그대로 좁히지 말고 주어("자신의")로 판단한다.
R4. 0이 되면 다른 키워드로 바뀌는 수치형 키워드는 0인 상태가 없다. "X가 있으면" = 1 이상 보유.
R5. 스킬 효과의 "해당 효과가 ~로 변경됨"은 그 인격의 키워드 상태 전환 (convert).

# 작성 규칙

- 원문의 모든 효과 줄을 빠짐없이 옮긴다. 스킬 효과, 각 코인, 모든 패시브·서포트 패시브, 덱에 들어가지 않는 변형 스킬 포함.
- 원문에 없는 조건·수치를 추가하지 않는다. 해석을 골랐다면 note 로 이유를 남긴다.
- "X 부여" = apply ... potency X. "X 횟수 N 증가" = gain target.X.count N. "X 위력 N 증가" = gain target.X.potency N.
- "(턴당 N회)" = limit N/turn, "(적 별로 턴당 N회)" = limit N/turn/target, "(스킬당 N회)" = limit N/use.
- "(최대 K)" = cap K. "X n당" = per(X, n). "X의 p%" = pct(X, p). "소모한 수치만큼" = consume ... -> 변수.
- "[합 불가능]" = flag unclashable, "[대상 변경 불가]" = flag fixed_target, "파괴 불가 코인" = 코인에 flag unbreakable,
  "[합 가능 반격]" = flag clashable_counter.
- 자주 쓰는 표현:
  "르누아르 소속 아군" = has_affiliation(it, "르누아르") · "충전 인격" = keyword_identity(it, 충전) (인격의 키워드 분류. 현재 보유 여부는 has)
  "자신을 제외한" = where: it != self · "대상이 아군이면" = when target is ally · "메인 타겟" = it is main_target
  "현재 체력 비율이 가장 낮은 아군" = pick(allies, by: it.hp_ratio, n: 1) · "속도가 가장 빠른" = by: it.speed, desc: 1
  "충전 횟수가 가장 적은" = by: it.충전.count · "(충전 인격 우선)" = prefer: keyword_identity(it, 충전)
  "편성 순서가 가장 빠른" = by: it.formation · "최대 공명 수 1당" = per(team.max_resonance, 1)
  "나태 피해 X" = deal target 나태 X · "아군 피격 시" = on ally_hit_taken · "아군이 공격하기 전" = on ally_before_attack
  "다른 유닛에게 거는 상시 효과(오라)" = always { modify ... to 대상 }
- 고정 어휘로 표현할 수 없으면: 효과의 일부라도 정확히 쓸 수 있으면 쓰고, 나머지는 hook(엔진 구현) 또는 unparsed(해석 불가)로 남긴다.
  어휘를 지어내지 않는다.
- 이 인격의 키워드 중 아래 [이미 정의된 키워드]에 없고 고유 메커니즘이 있는 것(수치형, 특수 충전 등)은 같은 출력 안에
  keyword 선언을 쓴다. 출혈·진동 같은 표준 상태는 선언하지 않는다.

# 출력 형식

설명 없이 ```lpdl 코드 블록 하나만 출력한다. 블록 안은 `lpdl 2` 로 시작하는 완전한 문서
(필요한 keyword 선언 + identity 하나)여야 한다.
"""

FEEDBACK = """\
검증기가 아래 문제를 보고했다. 같은 형식(```lpdl 코드 블록 하나, 완전한 문서)으로 고친 전체 문서를 다시 출력하라.
고칠 수 없는 부분은 지어내지 말고 hook 또는 unparsed 로 바꿔라.

{issues}
"""


def _fmt(names) -> str:
    return ", ".join(sorted(names))


def _table(d: dict) -> str:
    return "\n".join(f"  {k}: {v}" for k, v in d.items())


def language_reference() -> str:
    return Template(LANGUAGE).substitute(
        unit_fields=_fmt(V.UNIT_FIELDS), funcs=_fmt(V.FUNCS), events=_table(V.EVENTS),
        coin_events=_fmt(V.COIN_EVENTS), modify=_table(V.MODIFY_TARGETS), damage=_fmt(V.DAMAGE_TYPES),
        categories=_fmt(V.CATEGORIES), flags=_fmt(V.FLAGS), sins=", ".join(V.SINS),
    )


def _read(p: Path) -> str:
    return p.read_text(encoding="utf-8").strip()


def system_prompt(example_ids=(202,)) -> str:
    parts = [
        "당신은 림버스 컴퍼니 인격의 효과 원문을 LPDL v2 로 옮기는 컴파일러다. "
        "결과는 전투 엔진이 그대로 실행하므로 원문과 의미가 정확히 같아야 한다.",
        language_reference(),
        RULES,
        "# 이미 정의된 키워드 (출력에 다시 쓰지 말 것. 이름과 kind 를 그대로 사용)",
    ]
    for f in sorted((EXAMPLES / "keyword").glob("*.lpdl")):
        parts.append(f"```lpdl\n{_read(f)}\n```")
    for i in example_ids:
        parts.append(f"# 예시: identity {i}\n\n## 입력 원문\n\n{_read(EXAMPLES / 'source' / f'{i}.txt')}\n\n"
                     f"## 출력\n\n```lpdl\n{_read(EXAMPLES / 'identity' / f'{i}.lpdl')}\n```")
    return "\n\n".join(parts) + "\n"


def user_prompt(source: str) -> str:
    return f"아래 인격을 LPDL v2 로 옮겨라.\n\n{source.strip()}\n"


def feedback_prompt(issues: list[str]) -> str:
    return FEEDBACK.format(issues="\n".join(f"- {i}" for i in issues))
