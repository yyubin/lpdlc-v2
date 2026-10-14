package org.yyubin.lpdl.prompt;

public class LPDLGrammarSpec {

    public static String getFullSpec() {
        return """
            ## LPDL 개요

            LPDL은 림버스 컴퍼니 게임의 인격(Persona), 스킬, 패시브, 효과를 선언적으로 기술하기 위한 DSL입니다.

            ### 명명 규칙
            - 키워드: 소문자 (persona, skill, apply, self)
            - Enum 값: 대문자 + 언더스코어 (SYNC_4, ON_HIT, WRATH)
            - 문자열: 쌍따옴표 (예: "홍루", "출혈 강화")

            ---

            ## Persona 선언

            ```lpdl
            persona "인격 이름" {
              // === 필수 필드 ===
              sinner "시너 이름"    // 또는 sinner HONGLU
              grade 1|2|3           // 또는 grade 1★, grade TWO

              // === 선택 필드 ===
              // IMPORTANT: sin은 정확히 다음 7가지 값만 허용됩니다 (다른 값은 파서 에러):
              sin WRATH|LUST|SLOTH|GREED|GLOOM|PRIDE|ENVY
              // 주의: GLUTTONY는 존재하지 않음. GREED를 사용하세요.
              release "YYYY-MM-DD"
              maxLevel 숫자        // 최대 레벨 (기본: 50)
              defenseLevel 숫자    // 방어 레벨

              // 저항
              resistance {
                slash WEAK|NORMAL|RESIST,
                pierce WEAK|NORMAL|RESIST,
                blunt WEAK|NORMAL|RESIST
              }

              // 속도
              speed {
                min 숫자,
                max 숫자
              }

              // 체력
              health {
                base 숫자,
                growth 숫자.숫자,
                disturbed [숫자, 숫자, 숫자]
              }

              // 시즌 (필수! 생략 시 자동으로 type: NORMAL, number: 0 설정됨)
              season {
                type NORMAL|SEASON_NORMAL|SEASON_EVENT|WALPURGISNACHT,
                number 숫자
              }
              // NORMAL: 일반 인격 (기본값)
              // SEASON_NORMAL: 시즌 일반 인격
              // SEASON_EVENT: 시즌 이벤트 인격
              // WALPURGISNACHT: 발푸르기스의 밤 인격

              // 이미지 (여러 개 가능)
              image {
                type A|B|AC|BC|SD,
                url "https://...",
                priority 숫자,
                primary true|false
              }

              // 스킬 (여러 개 가능)
              skill 번호 "스킬 이름" { ... }

              // 패시브 (여러 개 가능)
              passive NORMAL|SUPPORT "패시브 이름" { ... }
            }
            ```

            ---

            ## Skill 선언

            ```lpdl
            skill 번호 "스킬 이름" {
              // === 필수/선택 필드 ===
              category ATTACK|DEFENSE
              // IMPORTANT: sin은 정확히 다음 7가지 값만 허용됩니다:
              sin WRATH|LUST|SLOTH|GREED|GLOOM|PRIDE|ENVY
              // 주의: GLUTTONY는 존재하지 않음. GREED를 사용하세요.
              attack SLASH|PIERCE|BLUNT    // ATTACK 스킬만
              defense EVADE|COUNTER|GUARD  // DEFENSE 스킬만
              quantity 1|2|3               // 스킬 개수
              keyword BLEED|CHARGE|BREATHE|...
              image "URL" 또는 none

              // === 원본 텍스트 (선택, 여러 줄 가능) ===
              text \"\"\"
              스킬의 원본 설명 텍스트
              여러 줄로 작성 가능
              \"\"\"

              // === Sync 레벨별 스탯 ===
              sync SYNC_3|SYNC_4 {
                basePower 숫자
                coinPower 숫자
                coinCount 숫자
                weight 숫자
                level 숫자 // skill의 번호와 같음

                // 스킬 전체 효과 (여러 개 가능)
                effect "효과 이름" {
                  // 원본 텍스트 (선택, 추천!)
                  text \"\"\"
                  [합 승리시] 다음 턴에 마비 3 부여
                  \"\"\"

                  trigger ON_USE|ON_HIT|ON_ATTACK_END|...

                  // 액션들
                  <target> <action> <params>
                }

                // 코인별 효과 (여러 개 가능)
                // 🔥 IMPORTANT: coin은 반드시 text와 effect를 **모두** 포함해야 함!
                coin 번호 NORMAL|UNBREAKABLE|REUSE { // 일반 코인|파괴불가 코인|재사용 코인
                  // 1. 코인 원본 텍스트 (필수!)
                  text \"\"\"
                  [적중시] 출혈 2 부여
                  \"\"\"

                  // 2. 구조화된 효과 (필수! 최소 1개 이상)
                  effect "효과 이름" {
                    trigger ON_HIT|ON_HEAD_HIT|...
                    <actions>
                  }

                  // 추가 효과가 있으면 effect 블록을 더 작성 가능
                  effect "추가 효과" {
                    trigger ON_CRITICAL_HIT
                    <actions>
                  }
                }
              }
            }
            ```

            ---

            ## Effect 시스템

            ### Trigger (트리거)

            **스킬 트리거**
            - `ON_HIT` - 적중시
            - `ON_CRITICAL_HIT` - 크리티컬 적중시
            - `ON_HEAD_HIT` - 앞면 적중시
            - `ON_TAIL_HIT` - 뒷면 적중시
            - `ON_USE` - 사용시
            - `ON_WIN_CLASH` - 합 승리시
            - `ON_WIN_CLASH_HIT` - 합 승리 적중시
            - `ON_LOSE_CLASH` - 합 패배시
            - `ON_DROP` - 이 스킬이 버려지면
            - `ON_ATTACK_END` - 공격 종료 시
            - `ON_KILL` - 적 처치 시

            **패시브 트리거**
            - `ON_BATTLE_START` - 전투 시작 시
            - `ON_TURN_START` - 턴 시작 시
            - `ON_TURN_END` - 턴 종료 시
            - `ON_ALLY_ATTACK` - 아군이 공격을 가할 시
            - `ON_ALLY_HIT` - 아군이 적중 시
            - `ON_ALLY_KILL` - 아군이 적 처치 시
            - `ON_DAMAGED` - 피격 시
            - `ON_STATUS_INFLICTED` - 상태 이상 부여 시
            - `ON_STATUS_RECEIVED` - 상태 이상 받을 시
            - `ALWAYS` - 전투 중 (항상 활성)

            ### Action 문법

            ```lpdl
            // 기본 형태
            <target> <action> <buff/debuff> <modifier> <value> [options]

            // Target
            - self         // 자신
            - target       // 대상
            - ally         // 아군
            - enemy        // 적
            - all          // 모두
            - random       // 랜덤

            // Action
            - apply        // 버프/디버프 적용
            - remove       // 버프/디버프 제거
            - deal         // 데미지
            - heal         // 회복
            - modify       // 수정 (power, coinPower 등)

            // 코인 선택자 (coins 옵션)
            - coins LAST   // 마지막 코인
            - coins FIRST  // 첫 번째 코인
            - coins ALL    // 모든 코인
            - coins CURRENT // 현재 코인
            - coins INDEX 3 // 특정 코인 (3번)

            // 예시
            self apply HP_HEAL +5
            target apply BLEED +3
            self remove CHARGE 10
            target apply BLEED ADD 2 nextTurn false
            modify power +30
            modify power +1 coins LAST  // 마지막 코인 위력 증가
            ```

            ### 조건 분기 (Branch)

            ```lpdl
            branch {
              order 숫자
              stopOnMatch true|false
              when <condition>
              <actions>
            }
            ```

            ### 조건 표현식

            ```lpdl
            // 비교 연산자
            self.HP > 50
            target.BLEED >= 5
            self.CHARGE < 10

            // 논리 연산자
            self.HP > 50 AND target.BLEED >= 3
            (self.CHARGE >= 10) OR (self.HP < 30)
            NOT target.IS_STAGGERED

            // 속성 참조
            self.HP           // 자신의 HP
            target.BLEED      // 대상의 출혈 스택
            self.CHARGE       // 자신의 차지
            all_allies.BLEED_COUNT  // 모든 아군의 출혈 보유 수
            ```

            ---

            ## Passive 선언

            ```lpdl
            passive NORMAL|SUPPORT "패시브 이름" {
              // === 원본 텍스트 (선택, 여러 줄 가능) ===
              text \"\"\"
              패시브의 원본 설명 텍스트
              합 진행 시 대상의 합 위력 –2
              \"\"\"

              // === 패시브 조건 (선택) ===
              condition HOLD|RESONATE sin WRATH|LUST|SLOTH|GREED|GLOOM|PRIDE|ENVY count 숫자
              // HOLD: 특정 죄악을 보유할 때 활성화
              // RESONATE: 특정 죄악으로 공명할 때 활성화
              // 예: condition HOLD sin WRATH count 3  // 분노 3개 보유 시

              // === Sync 레벨 (선택) ===
              syncLevel SYNC_1|SYNC_2|SYNC_3|SYNC_4
              // 특정 동조 레벨에서 활성화
              // 예: syncLevel SYNC_3

              trigger BATTLE_START|ON_TURN_START|...

              // 선택: 조건
              when <condition>

              // 액션 또는 분기
              <actions>

              // 또는
              branch {
                order 숫자
                when <condition>
                <actions>
              }
            }
            ```

            ---

            ## 버프/디버프 종류

            ### 상태 이상 관리
            - `STATUS_INFLICT` - 상태 이상 부여
            - `STATUS_REMOVE` - 상태 해제

            ### 스탯 버프/디버프
            - `ATTACK_POWER` - 공격력
            - `BUFF_DAMAGE_UP` - 공격력 증가
            - `BUFF_DAMAGE_DOWN` - 공격력 감소
            - `DEFENSE` - 방어력
            - `BUFF_DEFENSE_UP` - 방어력 증가
            - `BUFF_DEFENSE_DOWN` - 방어력 감소
            - `SPEED` - 속도
            - `DAMAGE_UP` - 데미지 증가

            ### 리소스 관리
            - `CHARGE` - 충전
            - `BREATH` - 호흡
            - `RESOURCE_GAIN` - 자원 획득 (충전, 경혈 등)
            - `RESOURCE_CONSUME` - 자원 소모
            - `RESOURCE_SET` - 자원 설정 (고정값으로)

            ### 피해/회복
            - `HP_HEAL` - 체력 회복
            - `HEAL_HP` - 체력 회복
            - `CONSUME_HP` - 체력 소모
            - `DAMAGE_MODIFY` - 피해량 변경 (%)
            - `POWER_MODIFY` - 위력 변경

            ### 코인 관련
            - `COIN_POWER_UP` - 코인 위력 +
            - `CLASH_POWER_UP` - 합 위력 +

            ### 디버프/상태이상
            - `BLEED` - 출혈
            - `BURN` - 화상
            - `TREMOR` - 진동
            - `RUPTURE` - 파열
            - `SINKING` - 침잠

            ### 특수 상태
            - `BLEED_AMPLIFY` - 출혈 증폭
            - `BLEED_COUNT` - 출혈 카운트
            - `BLEED_RESISTANCE` - 출혈 저항
            - `IS_STAGGERED` - 경직 상태

            ### 특수 효과
            - `COMMAND_ATTACK` - 원호 공격 명령
            - `TRANSFORM_SKILL` - 스킬 변환
            - `SUPPRESS_EFFECT` - 기존 효과 억제
            - `ETC` - 기타

            ---

            ## 중요 규칙

            1. **필수 필드**: persona의 `sinner`와 `grade`는 반드시 포함
            2. **쉼표**: 블록 내 각 필드는 쉼표로 구분
            3. **세미콜론 없음**: 각 문장 끝에 세미콜론 불필요
            4. **중괄호**: 모든 블록은 중괄호로 감싸기
            5. **문자열**: 이름과 URL은 큰따옴표로 감싸기
            6. **숫자**: grade는 1, 2, 3 중 하나 (숫자 또는 ★ 표기)
            7. **Enum**: 대문자와 언더스코어 조합
            8. **주석**: // 또는 /* */ 사용 가능
            9. **원본 텍스트**: 스킬, 코인, 패시브에 원본 텍스트를 포함할 경우 `text \"\"\"...\"\"\"`로 작성 (삼중 따옴표 사용, 여러 줄 가능)
            """;
    }
}
