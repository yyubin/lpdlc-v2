# LPDL v2 설계

LPDL(Limbus Persona Description Language)은 림버스 컴퍼니 인격·키워드의 **메커니즘(효과)**을 기술하는 언어다.
v2의 목적은 v1(Java/ANTLR → MySQL·Neo4j, 조회용)과 다르다. **gesellschaft 전투 엔진이 실행할 수 있는 spec**을 만드는 것이 목적이다.

```
원문(baslimbus) ──LLM──▶ .lpdl ──parse──▶ AST(Pydantic) ──validate──▶ 엔진(gesellschaft) 로딩
                    ▲                                     │
                    └──── 오류 / 검수 항목 피드백 ◀────────┘
```

## 1. v1에서 바뀐 점

| | v1 | v2 | 이유 |
|---|---|---|---|
| 구현 | Java 21 + ANTLR 4 | Python + lark(LALR) + Pydantic | 엔진과 같은 언어. 설치·테스트 단순 |
| 범위 | 스탯 + 효과 + 이미지 + 시즌 | **효과만** | 스탯은 데이터 소스에 이미 있음. 중복 입력 = 불일치 원인 |
| 이름 검사 | trigger / stat / unit 모두 `IDENT` (아무 이름이나 통과) | 문법은 NAME, **검증기가 `vocab.py` 목록으로 강제** + 오타 제안 | v1 예제 파일이 자기 문법으로 파싱되지 않는 등 이름이 어긋난 채 통과했음 |
| 상태이상 | `BLEED +2` (위력/횟수 구분 없음) | `apply target 진동 potency 2 count 1`, `target.진동.count` | 피해 계산에 둘 다 필요. v1 예제 6의 오역 원인 |
| 피해·위력 | `DAMAGE_UP`, `POWER_MODIFY` 등 혼재 | `modify` 대상 15종이 공식의 위치를 구분 (`coin_power` / `clash_power` / `final_power` / `damage_pct` …) | 엔진은 이 위치들을 각각 다르게 처리 |
| 수치 | 함수 금지 (`max()` 불가) | `min max floor ceil per pct has has_kind count_of pick` | "X n당", "최대 k" 표현은 거의 모든 인격에 나옴 |
| 소모 | `remove CHARGE 10` | `consume ref (N \| up_to N \| all) -> n` 후 `n` 사용 | "소모한 수치만큼" 패턴 |
| 해석 불가 | `ETC`로 덮음 | `unparsed """원문""" reason "..."`, `note "..."` → **검수 항목** | 오역을 숨기지 않음 |
| 탈출구 | 없음 | `hook 이름(args)` → Python 구현 | DSL로 안 되는 약 10% |
| 인격 고유 키워드 | 고정 enum + ETC | `keyword "이름" { prop kind ... }` 선언 + 게임 키워드 사전(484) | 르누아르 '보존', '코트' 같은 전용 자원 |
| 검증 | 구문뿐 | 구문 → 의미(이름, 참조, 문맥) → (예정) 엔진 테스트 | |

v1 코드는 `legacy/`에 그대로 보관한다 (빌드 대상 아님).

## 2. 언어 요약

```lpdl
lpdl 2

identity 202 "오트쿠튀르::르누아르 신발관" {
  use 코트 = "르누아르 개버딘 원단 코트"      # 공백 있는 키워드는 별칭으로

  skill S1 "불결하군" {
    on combat_start limit 2/turn {
      text """[전투 시작시] ... (턴당 2회)"""
      when self.보존.potency >= 3 and self.보존.count >= 12 {
        consume self.보존.count 6
        gain self.shield pct(self.max_hp, 5)
      }
    }
    on use {
      consume self.아르뮈르 up_to 15 -> n
      when n > 0 { modify final_power 1   modify damage_pct n * 3 cap 45 }
    }
    coin 1 { on hit { apply target 진동 potency 2 } }
  }

  passive "되먹임" {
    requires hold [나태, 오만, 질투] 2
    on hit_taken when self.shield > 0 limit 2/turn/target { apply attacker 진동 potency 2 }
  }
}

keyword "보존" { prop kind special_charge  prop count_max 20  prop inherit "충전"
                 on turn_end { gain self.보존.count -1 } }
```

### 구조
- `identity <id> "이름"? { use | budget | text | note | skill | passive | support }`
- `skill <S1|S2|S3|DEF|EGO> (variant N)? "이름"? { text | note | flag | block | coin N { ... } }`
- `passive|support "이름" { requires hold|resonate [죄악..] N | block | ... }`
- `keyword "이름" { prop kind|max|count_max|potency_max|inherit 값 | block | ... }`
- 블록: `on <event>(args)? [when 식] [limit N/turn|battle|use[/target]] [by 식] [every 식] { 문장 }`, `always { 문장 }`

### 문장
| 문장 | 의미 |
|---|---|
| `gain ref 식` | 자원·필드 증감 (음수 = 감소). `self.shield`, `self.보존.count`, `self.코트` |
| `apply 대상 키워드 potency 식 [count 식]` | 상태 부여 |
| `consume ref N \| up_to N \| all [-> 변수]` | 소모. `N` = 부족하면 소모 안 함(0), `up_to` = 있는 만큼 |
| `modify 대상 식` | 공식 항 수정 (`vocab.MODIFY_TARGETS`) |
| `burst 대상 키워드 [times 식]` | 진동 폭발 등 |
| `deal 대상 slash\|pierce\|blunt\|fixed\|stagger\|sanity 식` | 추가 피해 |
| `replace this\|슬롯 -> 슬롯 [variant N]` | 스킬 교체 ("~로 발동됨", "~로 적용됨") |
| `convert ref -> ref` | 키워드 전환 (코트 → 아르뮈르) |
| `when 식 {} elif 식 {} else {}` | 조건. "대신"은 `else` |
| `let 이름 = 식` | 지역 변수 (블록 범위) |
| `defer 이벤트 { }` | 이번 사용 중 나중 시점 ("이 효과가 발동했으면, 공격 종료 시 ...") |
| `hook 이름(args)` | Python 구현으로 위임 (검수 항목) |
| `text """원문"""` / `note "해석 메모"` / `unparsed """원문""" reason "..."` | 원문 추적과 검수 |

문장 옵션: `cap 식`(상한), `next_turn`, `this_turn`, `coins all|first|last|current|N`, `budget 이름`(턴당 공유 상한).

### 참조
- 유닛: `self` `target` `attacker` `it`(pick 안에서만) + 필드 `hp max_hp shield sanity speed stagger_gauge level formation`
- 키워드: `self.<키워드>.potency|count` (status·charge 계열), `self.<키워드>` (value 계열)
- 이벤트: `ev.amount`, `ev.source` (gained/consumed/applied/burst 안에서만)
- 코인: `coin.final_damage` 등 (코인 블록 안에서만), 스킬: `skill is basic_attack | S3 | S3 variant 1`
- 그룹: `allies` `enemies` → `pick(allies, where: ..., by: formation, n: 1)`, `count_of(allies, 조건)`

## 3. 검증 단계

1. **구문** (`parser.py`): lark LALR. 실패 시 줄:열과 기대 토큰을 알려줌
2. **의미** (`validate.py`): 이벤트, modify 대상, 함수, 분류, 플래그, 죄악, 키워드(별칭·선언·사전), 참조 경로(유닛 필드 vs 키워드, potency/count 필요 여부), 문맥(코인 전용 이벤트, `ev`/`coin`/`it`/`modify amount` 사용 위치), 지역 변수 범위, budget 선언, 스킬·코인 중복
   - 결과 등급: `error`(실패), `warning`, `review`(note·unparsed·hook → 사람 검수 큐)
3. **엔진 테스트** (예정, gesellschaft): 원문 문장마다 시나리오 테스트 ("보존 1 → 못 부여 안 됨")
4. **역번역 diff** (예정): AST → 자연어 → 원문과 비교 (컴파일 모델과 다른 컨텍스트)

## 4. 원문 해석 규칙 (사용자 확인, 2026-10-14)

컴파일 프롬프트와 검수 기준에 그대로 들어가는 규칙. 근거 예시는 #202.

| # | 규칙 | LPDL 표현 | 근거 |
|---|---|---|---|
| R1 | **줄이 다른 같은 태그(`[적중시]` 등)는 독립된 효과이고, 적힌 순서대로 모두 발동한다.** 한 태그 문단 안의 `-` 하위 항목은 하나의 효과 | 줄마다 별도 `on` 블록, 순서 유지. 조건이 붙은 줄도 앞 줄을 대체하지 않음 | S3 코인 3: `진동 폭발` + `보존 위력 ≥3이면 진동 폭발 2회` → 총 3회 |
| R2 | **"자신의 ~ 효과로"는 자기 자신이 원인인 효과만**(스킬·패시브 모두 포함). 아군 지원 효과로 받은 것은 제외. 출처 제한이 없으면 원문에 "~ 획득 시"처럼 쓰여 있다 | `on gained(...) by self` | 코트: "자신의 스킬, 패시브 효과로 보존 횟수를 획득 시" — 문구는 스킬·패시브를 나열하지만 패시브 포함 |
| R3 | **열거된 출처를 문자 그대로 좁히지 않는다.** 프로젝트 문 텍스트는 표현이 들쭉날쭉하므로, 수식어("스킬, 패시브")보다 주어("자신의")를 기준으로 판단 | | R2와 같은 사례 |
| R4 | **0이 되면 다른 키워드로 바뀌는 수치형 키워드는 0인 상태로 존재하지 않는다.** "X가 있으면" = 보유 중 = 1 이상 | `when self.아르뮈르 > 0`, 소모 결과 `n > 0` 도 같은 뜻 | 아르뮈르 에비이예: "수치가 0이 되면 코트로 변경" |
| R5 | 스킬 효과의 "해당 효과가 ~로 변경됨"은 그 인격의 키워드 상태 전환을 뜻한다 | `convert self.코트 -> self.아르뮈르 next_turn` | #202 DEF |

`gained` 이벤트의 `ev.amount`는 상한 적용 전 요청 수량이다 ("최대치를 초과하여 얻는 수치 포함").

#202의 해석 질문은 모두 확인됨 (review 항목은 hook 2개만 남음).

## 5. 컴파일러

```
gesellschaft DB ─source.py─▶ 원문 텍스트 ─┐
                                          ├─▶ Claude ─▶ ```lpdl``` ─▶ check() ─┬─ 통과 → compiled/identity/{id}.lpdl
prompt.py: 언어 요약 + vocab + R1~R5 ─────┘        ▲                          │
          + 정의된 키워드 + #202 예시(원문/출력)    └──── 오류 피드백 (최대 N회) ◀┘
```

- `check()` = 구문 → 의미 검증(예시 키워드 정의와 합쳐서) → **완전성 검사**(원문의 스킬·variant·효과 있는 코인·패시브가 모두 있는지) → 이미 정의된 키워드 재선언 금지
- 백엔드: `claude-code`(`claude -p`, 도구 없음, 빈 임시 디렉터리에서 실행, `--resume`으로 피드백) / `api`(Anthropic SDK, `claude-opus-5-5`, adaptive thinking, 시스템 프롬프트 캐시, `fallbacks: "default"`)
- 결과 보고서 `{id}.report.json`: 시도별 오류, 남은 검수 항목, 사용량

## 6. 첫 컴파일 결과 (#203·#204, claude-code 백엔드, 2026-10-14)

| | 시도 | 남은 오류 | 검수 항목 | 비용(추정) |
|---|---|---|---|---|
| #203 로쟈 · 수선실 | 2 (1차: 없는 키워드 "나태 내성 약화") | 0 | 30 | 약 $1.2 |
| #204 돈키호테 · 르누아르 브랜드 매니저 | 2 (1차: hook 인자에 스킬 참조 → 구문 오류) | 0 | 60 | 약 $1.7 |

hook·note 로 드러난 **어휘 부족** (자주 나온 순):
1. 소속 판정 ("르누아르 소속 아군") → `has_affiliation(unit, "르누아르")`
2. 인격 분류 ("충전 인격") → 키워드 태그 기반 `is_identity_of(unit, 충전)`
3. 대상 선택 기준: 현재 체력 비율, 충전 횟수, 속도, "충전 인격 우선" → `pick(by:)` 에 식 허용 + `hp_ratio` 필드
4. 아군 이벤트: 아군 피격, 아군 공격 시작 전, 아군 대상 공격 → `ally_hit_taken`, `ally_before_attack`, `target is ally`
5. 죄악 속성 피해 ("나태 피해") → `deal` 피해 유형에 죄악 7종
6. 최대 공명 수, 메인 타겟, 다중 대상 합산
7. 코인 재사용(조건부), 추가 스킬 발동, 진폭 변환(키워드 유형 변경)
8. 다른 유닛에 거는 오라 효과 (보존 신역: 아군 공격 레벨, 적 받는 피해)
9. 획득량 중 최대치 초과분 (`ev.overflow`)

### 어휘 확장 후 재컴파일 (같은 날)

| | 검수 항목 | hook | note | 시도 | 비용(추정) |
|---|---|---|---|---|---|
| #203 | 30 → **18** | 15 → **6** | 16 → 12 | 3 | $1.6 |
| #204 | 60 → **44** | 42 → **17** | 23 → 27 | 2 | $1.7 |

남은 hook 유형: 스킬 고유 속성(수비 스킬 미발동, 외부 재사용 불가, 체력 1 미만 감소 없음, 전 코인 파괴 불가, 흐트러짐 면역),
다중 대상 합산, 사전에 없는 키워드("나태 내성 약화"), 아군 공격 대상에게 스킬 발동.
재컴파일 중 드러난 것: 지역 변수 유닛 필드(`a.충전.count`) → 검증기 수정 완료, `skill is slash` → 공격 유형 분류 추가 (다음 컴파일부터 반영).

## 7. 다음 단계

1. 위 어휘 확장 (1~5 우선) → #203·#204 재컴파일 → hook 수 감소 확인
2. 검수 통과한 결과를 examples 로 승격 (few-shot 다양화)
3. gesellschaft 엔진 로더: AST → 이벤트 훅 등록. `hook`은 `hooks/<이름>.py`
4. ~~키워드 정의 확대: 표준 상태(출혈·화상·진동·파열·침잠·호흡·충전)를 `keywords/standard.lpdl`로~~ 완료 (2026-10-26). 컴파일러는 이 파일의 키워드 재선언을 오류로 본다
5. 역번역 diff 검증 (컴파일과 다른 컨텍스트에서 AST → 자연어 → 원문 비교)
