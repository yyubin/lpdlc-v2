CREATE (p1:Persona {name: '남부 세븐 협회 6과'})

SET p1.sinner = '이상', p1.sinner_id = 1

SET p1.grade = 'TWO'

SET p1.release_date = '2023-02-27'

SET p1.defense_level = 2

SET p1.season_type = 'NORMAL', p1.season_number = 0

SET p1.res_slash = 'NORMAL', p1.res_pierce = 'RESIST', p1.res_blunt = 'WEAK'

SET p1.min_speed = 4, p1.max_speed = 8

SET p1.base_health = 82, p1.growth_rate = 2.82, p1.disturbed_levels = [60, 30]

CREATE (s2:Skill {name: '플레쉬', skill_number: 1})

CREATE (p1)-[:HAS_SKILL {slot: 1}]->(s2)

SET s2.category = 'ATTACK'

SET s2.sin = 'GLOOM'

MERGE (sin3:SinAffinity {type: 'GLOOM'})
ON CREATE SET sin3.name = '우울'

CREATE (s2)-[:USES_SIN]->(sin3)

SET s2.attack_type = 'PIERCE'

SET s2.keyword = 'RUPTURE'

MERGE (status4:StatusEffect {type: 'RUPTURE'})
ON CREATE SET status4.name = '파열'

CREATE (s2)-[:HAS_KEYWORD]->(status4)

SET s2.sync_level = 'SYNC_4'

SET s2.base_power = 5

SET s2.coin_power = 7

SET s2.coin_count = 1

SET s2.weight = 1

SET s2.level = 0

CREATE (coin6:Coin {number: 1, type: 'NORMAL'})

CREATE (s2)-[:HAS_COIN {order: 1}]->(coin6)

SET coin6.description = '[앞면 적중시] 파열 2 부여'

CREATE (eff7:Effect {name: '파열 부여'})

CREATE (coin6)-[:HAS_EFFECT]->(eff7)

SET eff7.trigger = 'ON_HEAD_HIT'

MERGE (trig8:Trigger {type: 'ON_HEAD_HIT'})
ON CREATE SET trig8.name = '앞면 적중시'

CREATE (eff7)-[:TRIGGERS_ON]->(trig8)

CREATE (act9:Action {type: 'APPLY', target: 'TARGET', stat: 'RUPTURE', value: '+2'})

CREATE (eff7)-[:PERFORMS]->(act9)

MERGE (status10:StatusEffect {type: 'RUPTURE'})
ON CREATE SET status10.name = '파열'

CREATE (act9)-[:APPLIES]->(status10)

CREATE (s11:Skill {name: '리포스트', skill_number: 2})

CREATE (p1)-[:HAS_SKILL {slot: 2}]->(s11)

SET s11.category = 'ATTACK'

SET s11.sin = 'GREED'

MERGE (sin12:SinAffinity {type: 'GREED'})
ON CREATE SET sin12.name = '탐식'

CREATE (s11)-[:USES_SIN]->(sin12)

SET s11.attack_type = 'PIERCE'

SET s11.keyword = 'RUPTURE'

MERGE (status13:StatusEffect {type: 'RUPTURE'})
ON CREATE SET status13.name = '파열'

CREATE (s11)-[:HAS_KEYWORD]->(status13)

SET s11.sync_level = 'SYNC_4'

SET s11.base_power = 5

SET s11.coin_power = 4

SET s11.coin_count = 2

SET s11.weight = 1

SET s11.level = 0

CREATE (eff15:Effect {name: '합 승리 시 상태이상 부여'})

CREATE (s11)-[:HAS_EFFECT]->(eff15)

SET eff15.trigger = 'ON_WIN_CLASH'

MERGE (trig16:Trigger {type: 'ON_WIN_CLASH'})
ON CREATE SET trig16.name = '합 승리시'

CREATE (eff15)-[:TRIGGERS_ON]->(trig16)

CREATE (act17:Action {type: 'APPLY', target: 'TARGET', stat: 'PARALYSIS', value: '+3'})

CREATE (eff15)-[:PERFORMS]->(act17)

MERGE (status18:StatusEffect {type: 'PARALYSIS'})
ON CREATE SET status18.name = 'PARALYSIS'

CREATE (act17)-[:APPLIES]->(status18)

SET act17.next_turn = true

CREATE (act19:Action {type: 'APPLY', target: 'TARGET', stat: 'RUPTURE', value: '+1'})

CREATE (eff15)-[:PERFORMS]->(act19)

MERGE (status20:StatusEffect {type: 'RUPTURE'})
ON CREATE SET status20.name = '파열'

CREATE (act19)-[:APPLIES]->(status20)

CREATE (coin21:Coin {number: 2, type: 'NORMAL'})

CREATE (s11)-[:HAS_COIN {order: 2}]->(coin21)

SET coin21.description = '[적중시] 다음 턴에 취약 1 부여
        [적중시] 파열 1 부여'

CREATE (eff22:Effect {name: '취약 및 파열 부여'})

CREATE (coin21)-[:HAS_EFFECT]->(eff22)

SET eff22.trigger = 'ON_HIT'

MERGE (trig23:Trigger {type: 'ON_HIT'})
ON CREATE SET trig23.name = '적중시'

CREATE (eff22)-[:TRIGGERS_ON]->(trig23)

CREATE (act24:Action {type: 'APPLY', target: 'TARGET', stat: 'VULNERABLE', value: '+1'})

CREATE (eff22)-[:PERFORMS]->(act24)

MERGE (status25:StatusEffect {type: 'VULNERABLE'})
ON CREATE SET status25.name = 'VULNERABLE'

CREATE (act24)-[:APPLIES]->(status25)

SET act24.next_turn = true

CREATE (act26:Action {type: 'APPLY', target: 'TARGET', stat: 'RUPTURE', value: '+1'})

CREATE (eff22)-[:PERFORMS]->(act26)

MERGE (status27:StatusEffect {type: 'RUPTURE'})
ON CREATE SET status27.name = '파열'

CREATE (act26)-[:APPLIES]->(status27)

CREATE (s28:Skill {name: '물리네', skill_number: 3})

CREATE (p1)-[:HAS_SKILL {slot: 3}]->(s28)

SET s28.category = 'ATTACK'

SET s28.sin = 'SLOTH'

MERGE (sin29:SinAffinity {type: 'SLOTH'})
ON CREATE SET sin29.name = '나태'

CREATE (s28)-[:USES_SIN]->(sin29)

SET s28.attack_type = 'BLUNT'

SET s28.keyword = 'RUPTURE'

MERGE (status30:StatusEffect {type: 'RUPTURE'})
ON CREATE SET status30.name = '파열'

CREATE (s28)-[:HAS_KEYWORD]->(status30)

SET s28.sync_level = 'SYNC_4'

SET s28.base_power = 5

SET s28.coin_power = 3

SET s28.coin_count = 3

SET s28.weight = 1

SET s28.level = 0

CREATE (coin32:Coin {number: 1, type: 'NORMAL'})

CREATE (s28)-[:HAS_COIN {order: 1}]->(coin32)

SET coin32.description = '[적중시] 마지막 코인의 효과 부여 값 + 1'

CREATE (eff33:Effect {name: '마지막 코인 효과 증폭'})

CREATE (coin32)-[:HAS_EFFECT]->(eff33)

SET eff33.trigger = 'ON_HIT'

MERGE (trig34:Trigger {type: 'ON_HIT'})
ON CREATE SET trig34.name = '적중시'

CREATE (eff33)-[:TRIGGERS_ON]->(trig34)

CREATE (act35:Action {type: 'MODIFY', modify_target: 'POWER', value: '+1'})

CREATE (eff33)-[:PERFORMS]->(act35)

SET act35.coin_selector = 'LAST'

CREATE (coin36:Coin {number: 2, type: 'NORMAL'})

CREATE (s28)-[:HAS_COIN {order: 2}]->(coin36)

SET coin36.description = '[적중시] 마지막 코인의 효과 부여 값 + 1'

CREATE (eff37:Effect {name: '마지막 코인 효과 증폭'})

CREATE (coin36)-[:HAS_EFFECT]->(eff37)

SET eff37.trigger = 'ON_HIT'

MERGE (trig38:Trigger {type: 'ON_HIT'})
ON CREATE SET trig38.name = '적중시'

CREATE (eff37)-[:TRIGGERS_ON]->(trig38)

CREATE (act39:Action {type: 'MODIFY', modify_target: 'POWER', value: '+1'})

CREATE (eff37)-[:PERFORMS]->(act39)

SET act39.coin_selector = 'LAST'

CREATE (coin40:Coin {number: 3, type: 'NORMAL'})

CREATE (s28)-[:HAS_COIN {order: 3}]->(coin40)

SET coin40.description = '[적중시] 다음 턴에 관통 취약 1 부여
        [적중시] 파열 1 부여'

CREATE (eff41:Effect {name: '관통 취약 및 파열 부여'})

CREATE (coin40)-[:HAS_EFFECT]->(eff41)

SET eff41.trigger = 'ON_HIT'

MERGE (trig42:Trigger {type: 'ON_HIT'})
ON CREATE SET trig42.name = '적중시'

CREATE (eff41)-[:TRIGGERS_ON]->(trig42)

CREATE (act43:Action {type: 'APPLY', target: 'TARGET', stat: 'PIERCE_VULNERABLE', value: '+1'})

CREATE (eff41)-[:PERFORMS]->(act43)

MERGE (status44:StatusEffect {type: 'PIERCE_VULNERABLE'})
ON CREATE SET status44.name = 'PIERCE_VULNERABLE'

CREATE (act43)-[:APPLIES]->(status44)

SET act43.next_turn = true

CREATE (act45:Action {type: 'APPLY', target: 'TARGET', stat: 'RUPTURE', value: '+1'})

CREATE (eff41)-[:PERFORMS]->(act45)

MERGE (status46:StatusEffect {type: 'RUPTURE'})
ON CREATE SET status46.name = '파열'

CREATE (act45)-[:APPLIES]->(status46)

CREATE (s47:Skill {name: '가드', skill_number: 4})

CREATE (p1)-[:HAS_SKILL {slot: 4}]->(s47)

SET s47.category = 'DEFENSE'

SET s47.sin = 'GREED'

MERGE (sin48:SinAffinity {type: 'GREED'})
ON CREATE SET sin48.name = '탐식'

CREATE (s47)-[:USES_SIN]->(sin48)

SET s47.defense_type = 'GUARD'

SET s47.sync_level = 'SYNC_4'

SET s47.base_power = 9

SET s47.coin_power = 3

SET s47.coin_count = 1

SET s47.weight = 1

SET s47.level = 2

CREATE (passive50:Passive {name: '관찰', kind: 'NORMAL'})

CREATE (p1)-[:HAS_PASSIVE]->(passive50)

CREATE (eff51:Effect {name: '관찰 효과'})

CREATE (passive50)-[:HAS_EFFECT]->(eff51)

SET passive50.condition_type = 'RESONATE', passive50.condition_sin = 'GREED', passive50.condition_count = 4

MERGE (sin52:SinAffinity {type: 'GREED'})
ON CREATE SET sin52.name = '탐식'

CREATE (passive50)-[:REQUIRES_SIN {condition: 'RESONATE', count: 4}]->(sin52)

SET eff51.trigger = 'ON_CLASH'

MERGE (trig53:Trigger {type: 'ON_CLASH'})
ON CREATE SET trig53.name = '합 진행시'

CREATE (eff51)-[:TRIGGERS_ON]->(trig53)

CREATE (act54:Action {type: 'APPLY', target: 'TARGET', stat: 'CLASH_POWER_DOWN', value: '-2'})

CREATE (eff51)-[:PERFORMS]->(act54)

CREATE (passive55:Passive {name: '분석', kind: 'SUPPORT'})

CREATE (p1)-[:HAS_PASSIVE]->(passive55)

CREATE (eff56:Effect {name: '분석 효과'})

CREATE (passive55)-[:HAS_EFFECT]->(eff56)

SET passive55.condition_type = 'RESONATE', passive55.condition_sin = 'GREED', passive55.condition_count = 3

MERGE (sin57:SinAffinity {type: 'GREED'})
ON CREATE SET sin57.name = '탐식'

CREATE (passive55)-[:REQUIRES_SIN {condition: 'RESONATE', count: 3}]->(sin57)

SET eff56.trigger = 'ON_CLASH'

MERGE (trig58:Trigger {type: 'ON_CLASH'})
ON CREATE SET trig58.name = '합 진행시'

CREATE (eff56)-[:TRIGGERS_ON]->(trig58)

CREATE (act59:Action {type: 'APPLY', target: 'ALLY', stat: 'CLASH_POWER_UP', value: '+1'})

CREATE (eff56)-[:PERFORMS]->(act59)