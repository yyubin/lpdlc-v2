INSERT INTO persona (name) VALUES ('남부 세븐 협회 6과');
SET @persona_1 = LAST_INSERT_ID();
UPDATE persona SET sinner_id = 1 WHERE id = @persona_1;
UPDATE persona SET grade = 'TWO' WHERE id = @persona_1;
UPDATE persona SET release_date = '2023-02-27' WHERE id = @persona_1;
UPDATE persona SET slash_resistance = 'NORMAL', penetration_resistance = 'RESIST', blunt_resistance = 'WEAK' WHERE id = @persona_1;
UPDATE persona SET min_speed = 4, max_speed = 8 WHERE id = @persona_1;
UPDATE persona SET base_health = 82, growth_rate = 2.82, disturbed2 = 30, disturbed1 = 60 WHERE id = @persona_1;
INSERT INTO skill (persona_id, skill_number, name) VALUES (@persona_1, 1, '플레쉬');
SET @skill_1 = LAST_INSERT_ID();
UPDATE skill SET skill_category = 'ATTACK' WHERE id = @skill_1;
UPDATE skill SET sin_affinity = 'GLOOM' WHERE id = @skill_1;
UPDATE skill SET attack_type = 'PIERCE' WHERE id = @skill_1;
UPDATE skill SET keyword_type = 'RUPTURE' WHERE id = @skill_1;
INSERT INTO skill_stats_by_sync (skill_id) VALUES (@skill_1);
SET @skill_stats_by_sync_1 = LAST_INSERT_ID();
UPDATE skill_stats_by_sync SET sync_level = 'SYNC_4' WHERE id = @skill_stats_by_sync_1;
UPDATE skill_stats_by_sync SET base_power = 5 WHERE id = @skill_stats_by_sync_1;
UPDATE skill_stats_by_sync SET coin_power = 7 WHERE id = @skill_stats_by_sync_1;
UPDATE skill_stats_by_sync SET coin_count = 1 WHERE id = @skill_stats_by_sync_1;
UPDATE skill_stats_by_sync SET weight = 1 WHERE id = @skill_stats_by_sync_1;
UPDATE skill_stats_by_sync SET level = 0 WHERE id = @skill_stats_by_sync_1;
INSERT INTO skill_coin (stats_by_sync_id, order_index, coin_type) VALUES (@skill_stats_by_sync_1, 1, 'NORMAL');
SET @skill_coin_1 = LAST_INSERT_ID();
INSERT INTO coin_description (skill_coin_id, original_text) VALUES (@skill_coin_1, '
        [앞면 적중시] 파열 2 부여
        ');
SET @coin_description_1 = LAST_INSERT_ID();
INSERT INTO skill (persona_id, skill_number, name) VALUES (@persona_1, 2, '리포스트');
SET @skill_2 = LAST_INSERT_ID();
UPDATE skill SET skill_category = 'ATTACK' WHERE id = @skill_2;
UPDATE skill SET sin_affinity = 'GREED' WHERE id = @skill_2;
UPDATE skill SET attack_type = 'PIERCE' WHERE id = @skill_2;
UPDATE skill SET keyword_type = 'RUPTURE' WHERE id = @skill_2;
INSERT INTO skill_stats_by_sync (skill_id) VALUES (@skill_2);
SET @skill_stats_by_sync_2 = LAST_INSERT_ID();
UPDATE skill_stats_by_sync SET sync_level = 'SYNC_4' WHERE id = @skill_stats_by_sync_2;
UPDATE skill_stats_by_sync SET base_power = 5 WHERE id = @skill_stats_by_sync_2;
UPDATE skill_stats_by_sync SET coin_power = 4 WHERE id = @skill_stats_by_sync_2;
UPDATE skill_stats_by_sync SET coin_count = 2 WHERE id = @skill_stats_by_sync_2;
UPDATE skill_stats_by_sync SET weight = 1 WHERE id = @skill_stats_by_sync_2;
UPDATE skill_stats_by_sync SET level = 0 WHERE id = @skill_stats_by_sync_2;
INSERT INTO skill_coin (stats_by_sync_id, order_index, coin_type) VALUES (@skill_stats_by_sync_2, 2, 'NORMAL');
SET @skill_coin_2 = LAST_INSERT_ID();
INSERT INTO coin_description (skill_coin_id, original_text) VALUES (@skill_coin_2, '
        [적중시] 다음 턴에 취약 1 부여
        [적중시] 파열 1 부여
        ');
SET @coin_description_2 = LAST_INSERT_ID();
INSERT INTO skill (persona_id, skill_number, name) VALUES (@persona_1, 3, '물리네');
SET @skill_3 = LAST_INSERT_ID();
UPDATE skill SET skill_category = 'ATTACK' WHERE id = @skill_3;
UPDATE skill SET sin_affinity = 'SLOTH' WHERE id = @skill_3;
UPDATE skill SET attack_type = 'BLUNT' WHERE id = @skill_3;
UPDATE skill SET keyword_type = 'RUPTURE' WHERE id = @skill_3;
INSERT INTO skill_stats_by_sync (skill_id) VALUES (@skill_3);
SET @skill_stats_by_sync_3 = LAST_INSERT_ID();
UPDATE skill_stats_by_sync SET sync_level = 'SYNC_4' WHERE id = @skill_stats_by_sync_3;
UPDATE skill_stats_by_sync SET base_power = 5 WHERE id = @skill_stats_by_sync_3;
UPDATE skill_stats_by_sync SET coin_power = 3 WHERE id = @skill_stats_by_sync_3;
UPDATE skill_stats_by_sync SET coin_count = 3 WHERE id = @skill_stats_by_sync_3;
UPDATE skill_stats_by_sync SET weight = 1 WHERE id = @skill_stats_by_sync_3;
UPDATE skill_stats_by_sync SET level = 0 WHERE id = @skill_stats_by_sync_3;
INSERT INTO skill_coin (stats_by_sync_id, order_index, coin_type) VALUES (@skill_stats_by_sync_3, 1, 'NORMAL');
SET @skill_coin_3 = LAST_INSERT_ID();
INSERT INTO coin_description (skill_coin_id, original_text) VALUES (@skill_coin_3, '
        [적중시] 마지막 코인의 효과 부여 값 + 1
        ');
SET @coin_description_3 = LAST_INSERT_ID();
INSERT INTO skill_coin (stats_by_sync_id, order_index, coin_type) VALUES (@skill_stats_by_sync_3, 2, 'NORMAL');
SET @skill_coin_4 = LAST_INSERT_ID();
INSERT INTO coin_description (skill_coin_id, original_text) VALUES (@skill_coin_4, '
        [적중시] 마지막 코인의 효과 부여 값 + 1
        ');
SET @coin_description_4 = LAST_INSERT_ID();
INSERT INTO skill_coin (stats_by_sync_id, order_index, coin_type) VALUES (@skill_stats_by_sync_3, 3, 'NORMAL');
SET @skill_coin_5 = LAST_INSERT_ID();
INSERT INTO coin_description (skill_coin_id, original_text) VALUES (@skill_coin_5, '
        [적중시] 다음 턴에 관통 취약 1 부여
        [적중시] 파열 1 부여
        ');
SET @coin_description_5 = LAST_INSERT_ID();
INSERT INTO skill (persona_id, skill_number, name) VALUES (@persona_1, 4, '가드');
SET @skill_4 = LAST_INSERT_ID();
UPDATE skill SET skill_category = 'DEFENSE' WHERE id = @skill_4;
UPDATE skill SET sin_affinity = 'GREED' WHERE id = @skill_4;
UPDATE skill SET defense_type = 'GUARD' WHERE id = @skill_4;
INSERT INTO skill_stats_by_sync (skill_id) VALUES (@skill_4);
SET @skill_stats_by_sync_4 = LAST_INSERT_ID();
UPDATE skill_stats_by_sync SET sync_level = 'SYNC_4' WHERE id = @skill_stats_by_sync_4;
UPDATE skill_stats_by_sync SET base_power = 9 WHERE id = @skill_stats_by_sync_4;
UPDATE skill_stats_by_sync SET coin_power = 3 WHERE id = @skill_stats_by_sync_4;
UPDATE skill_stats_by_sync SET coin_count = 1 WHERE id = @skill_stats_by_sync_4;
UPDATE skill_stats_by_sync SET weight = 1 WHERE id = @skill_stats_by_sync_4;
UPDATE skill_stats_by_sync SET level = 2 WHERE id = @skill_stats_by_sync_4;
INSERT INTO persona_passive (persona_id, kind, name) VALUES (@persona_1, 'NORMAL', '관찰');
SET @persona_passive_1 = LAST_INSERT_ID();
INSERT INTO passive_description (persona_passive_id, original_text) VALUES (@persona_passive_1, '
    합 진행 시 대상의 합 위력 –2
    ');
SET @passive_description_1 = LAST_INSERT_ID();
INSERT INTO persona_passive (persona_id, kind, name) VALUES (@persona_1, 'SUPPORT', '분석');
SET @persona_passive_2 = LAST_INSERT_ID();
INSERT INTO passive_description (persona_passive_id, original_text) VALUES (@persona_passive_2, '
    최대 체력이 가장 높은 아군 1명 합 진행 시 합 위력 +1
    ');
SET @passive_description_2 = LAST_INSERT_ID();