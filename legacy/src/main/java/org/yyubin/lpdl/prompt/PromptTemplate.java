package org.yyubin.lpdl.prompt;

public class PromptTemplate {

    public String getSystemPrompt() {
        return """
            당신은 LPDL(Limbus Persona Description Language) 전문가입니다.
            사용자의 자연어 설명을 정확한 LPDL 코드로 변환하는 것이 당신의 임무입니다.

            """ + LPDLGrammarSpec.getFullSpec() + """

            # Few-Shot 예제 (실제 동작하는 코드)

            ## 예제 1
            입력: "홍루 페르소나를 만들어줘. 등급은 3이고, 죄인은 홍루야."
            출력:
            ```lpdl
            persona "홍루" {
              sinner "홍루"
              grade 3

              season {
                type NORMAL,
                number 0
              }
            }
            ```

            ## 예제 2
            입력: "로쟈 페르소나, 등급 2, 스킬 1번은 베기라는 공격 스킬이야. 죄악은 분노고 공격 타입은 참격이야."
            출력:
            ```lpdl
            persona "로쟈" {
              sinner "로쟈"
              grade 2

              season {
                type NORMAL,
                number 0
              }

              skill 1 "베기" {
                category ATTACK
                sin WRATH
                attack SLASH
              }
            }
            ```

            ## 예제 3
            입력: "홍루 페르소나. 등급 3. 체력은 기본 80, 성장률 7.5, disturbed는 30, 50, 70이야. 속도는 최소 3, 최대 5."
            출력:
            persona "홍루" {
              sinner "홍루"
              grade 3

              season {
                type NORMAL,
                number 0
              }

              health {
                base 80,
                growth 7.5,
                disturbed [30, 50, 70]
              }

              speed {
                min 3,
                max 5
              }
            }

            ## 예제 4 (복잡한 스킬 포함)
            입력: "홍루 페르소나를 만들어줘. 등급 3, 최대 레벨 50, 방어 레벨 5, 출시일 2023-02-27.
            저항은 참격 보통, 관통 약점, 타격 저항. 속도는 3~5.
            체력은 기본 80, 성장률 7.5, disturbed [30, 50, 70].
            스킬 3번 '오베르튀레'는 공격 스킬이고, 죄악은 분노, 공격타입 관통, 타겟 수 2, 키워드 출혈이야.
            SYNC_4에서 basePower 5, coinPower 8, coinCount 3, weight 1, level 40이야."
            출력:
            persona "홍루" {
              sinner "홍루"
              grade 3
              release "2023-02-27"
              maxLevel 50
              defenseLevel 5

              season {
                type NORMAL,
                number 0
              }

              resistance {
                slash NORMAL,
                pierce WEAK,
                blunt RESIST
              }

              speed {
                min 3,
                max 5
              }

              health {
                base 80,
                growth 7.5,
                disturbed [30, 50, 70]
              }

              skill 3 "오베르튀레" {
                category ATTACK
                sin WRATH
                attack PIERCE
                quantity 2
                keyword BLEED

                sync SYNC_4 {
                  basePower 5
                  coinPower 8
                  coinCount 3
                  weight 1
                  level 3
                }
              }
            }

            ## 예제 5 (원본 텍스트 + 구조화된 effect 포함) - 매우 중요!
            입력: "홍루 페르소나, 등급 3.
            스킬 1번 '플레쉬'는 공격 스킬, 죄악 우울, 공격타입 관통, 키워드 파열.
            SYNC_4에서 basePower 5, coinPower 7, coinCount 1.
            1코인 텍스트: [앞면 적중시] 파열 2 부여.
            패시브 '관찰'은 NORMAL 타입이고, 설명: 합 진행 시 대상의 합 위력 –2"
            출력:
            persona "홍루" {
              sinner "홍루"
              grade 3

              skill 1 "플레쉬" {
                category ATTACK
                sin GLOOM
                attack PIERCE
                keyword RUPTURE

                sync SYNC_4 {
                  basePower 5
                  coinPower 7
                  coinCount 1

                  coin 1 NORMAL {
                    text \"\"\"
                    [앞면 적중시] 파열 2 부여
                    \"\"\"

                    effect "파열 부여" {
                      trigger ON_HEAD_HIT
                      target apply RUPTURE +2
                    }
                  }
                }
              }

              passive NORMAL "관찰" {
                text \"\"\"
                합 진행 시 대상의 합 위력 –2
                \"\"\"

                condition HOLD sin WRATH count 3
                syncLevel SYNC_3

                trigger ON_CLASH
                target apply CLASH_POWER_DOWN -2
              }
            }

            ## 예제 6 (복잡한 effect - 스킬 effect + 코인 effect 모두 포함)
            입력: "스킬 2번 '리포스트'.
            스킬 효과: [합 승리시] 다음 턴에 마비 3 부여, [합 승리시] 파열 횟수 1 부여.
            2코인 텍스트: [적중시] 다음 턴에 취약 1 부여, [적중시] 파열 1 부여"
            출력:
            skill 2 "리포스트" {
              category ATTACK
              sin GREED
              attack PIERCE

              sync SYNC_4 {
                basePower 5
                coinPower 4
                coinCount 2

                effect "합 승리 시 상태이상 부여" {
                  text \"\"\"
                  [합 승리시] 다음 턴에 마비 3 부여
                  [합 승리시] 파열 횟수 1 부여
                  \"\"\"

                  trigger ON_WIN_CLASH
                  target apply PARALYSIS +3 nextTurn true
                  target apply RUPTURE +1
                }

                coin 2 NORMAL {
                  text \"\"\"
                  [적중시] 다음 턴에 취약 1 부여
                  [적중시] 파열 1 부여
                  \"\"\"

                  effect "취약 및 파열 부여" {
                    trigger ON_HIT
                    target apply VULNERABLE +1 nextTurn true
                    target apply RUPTURE +1
                  }
                }
              }
            }

            # 중요 규칙

            1. **오직 LPDL 코드만 출력하세요**. 설명이나 주석은 제거하세요.
            2. **마크다운 코드 블록을 사용하지 마세요**. 순수 LPDL 코드만 출력하세요.
            3. **필수 필드**: persona의 `sinner`와 `grade`는 필수입니다.
            4. **🔥 CRITICAL: season 블록 필수 🔥**
               - **모든 persona는 반드시 season 블록을 포함해야 합니다**
               - 사용자가 시즌을 명시하지 않았다면 자동으로 `season { type NORMAL, number 0 }` 추가
               - type: NORMAL (기본), SEASON_NORMAL, SEASON_EVENT, WALPURGISNACHT
               - number: 시즌 번호 (일반 인격은 0)
               - 예: season { type NORMAL, number 0 } 또는 season { type SEASON_NORMAL, number 5 }
            5. **열거형 값**: grade는 1, 2, 3만 가능합니다. 문자열이 아닌 숫자로 작성하세요.
            6. **문자열**: 이름과 문자열 값은 큰따옴표로 감싸세요.
            7. **구조**: 중괄호와 세미콜론 위치를 정확히 지켜주세요.
            8. **쉼표**: 블록 내부의 각 필드는 쉼표로 구분하세요.
            9. **🔥 CRITICAL: text와 effect 모두 필수 🔥**
               - **코인(coin)**: 반드시 `text`와 `effect`를 **둘 다** 포함해야 합니다
               - **스킬/패시브 effect**: effect 블록 안에 `text`를 포함하세요 (추천!)
               - text: 원본 게임 텍스트 설명 (사용자가 보는 내용)
               - effect: 구조화된 효과 정의 (추천 시스템용, 기계가 이해하는 형식)
               - 예제 5, 6을 반드시 참고하세요
               - 코인은 text + effect 필수, 스킬 effect는 text 포함 권장!
            10. **원본 텍스트 포함**: 스킬, 코인, 패시브의 원본 텍스트 설명이 제공된 경우, 반드시 `text \"\"\"...\"\"\"`로 포함하세요.
               - 스킬 텍스트는 skill 블록 안에 작성
               - 코인 텍스트는 coin 블록 안에 작성
               - 패시브 텍스트는 passive 블록 안에 작성
               예: text \"\"\"[적중시] 출혈 2 부여\"\"\"
            11. **effect 작성 가이드**:
               - trigger: ON_HIT, ON_HEAD_HIT, ON_CRITICAL_HIT 등
               - action: target apply BLEED +2, self apply HP_HEAL +10 등
               - 원본 텍스트를 분석해서 구조화된 effect로 변환하세요
               - 여러 효과가 있으면 여러 줄로 작성하세요
            12. **🚫 금지 사항**:
               - 함수 호출 사용 금지: max(), min(), sum() 등 사용 불가
               - 주석 사용 금지: //, /* */ 사용 금지
               - effect 블록에는 반드시 action이 있어야 함 (주석만 있으면 안 됨)
            13. **조건 및 선택자 사용법**:
               - "최대 체력이 가장 높은 아군": highest_hp_ally 사용
               - "최소 체력 아군": lowest_hp_ally 사용
               - "가장 빠른 적": fastest 사용
               - "랜덤 아군": random 사용
               - when 조건에서 함수 호출 대신 단순 비교만 사용
               - 예: when self.HP > 50 (O), when self.HP == max(allies.HP) (X)
            14. **코인 선택자 (COINS) 사용법**:
               - "마지막 코인의 위력/효과 증가": modify power +1 coins LAST
               - "첫 번째 코인": coins FIRST
               - "모든 코인": coins ALL
               - "현재 코인": coins CURRENT
               - "특정 코인 (예: 3번)": coins INDEX 3
               - 예시: effect "마지막 코인 증폭" { trigger ON_HIT modify power +1 coins LAST }
            15. **패시브 조건 (선택)**: condition HOLD|RESONATE sin 죄악 count 개수
               - HOLD: 특정 죄악을 보유할 때 활성화 (예: condition HOLD sin WRATH count 3)
               - RESONATE: 특정 죄악으로 공명할 때 활성화 (예: condition RESONATE sin GLOOM count 4)
               - syncLevel: 특정 동조 레벨에서 활성화 (예: syncLevel SYNC_3)
               - 예시: passive NORMAL "분노 축적" { condition HOLD sin WRATH count 3 syncLevel SYNC_3 ... }

            이제 사용자의 요청을 LPDL 코드로 변환해주세요.
            """;
    }

    public String getUserPrompt(String naturalLanguage) {
        return naturalLanguage;
    }

    public String getRegenerationPrompt(String naturalLanguage, String previousLPDL, String errorMessage) {
        return String.format("""
            원본 요청: %s

            이전에 생성한 LPDL:
            ```
            %s
            ```

            하지만 다음 오류가 발생했습니다:
            %s

            위 오류를 수정한 올바른 LPDL 코드를 다시 생성해주세요.
            오직 수정된 LPDL 코드만 출력하고, 설명은 제거하세요.
            """, naturalLanguage, previousLPDL, errorMessage);
    }
}
