package org.yyubin.lpdl.exporter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.yyubin.lpdl.parser.LPDLLexer;
import org.yyubin.lpdl.parser.LPDLParser;

import static org.junit.jupiter.api.Assertions.*;

class RDBExporterTest {

    @Test
    void testSimplePersona() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3
            }
            """;

        String sql = parseAndExport(lpdl);

        // 검증
        assertNotNull(sql);
        assertTrue(sql.contains("INSERT INTO persona"));
        assertTrue(sql.contains("'홍루'"));
        // AUTO_INCREMENT 사용 확인
        assertFalse(sql.contains("INSERT INTO persona (id,"), "id should not be in INSERT statement");
        assertTrue(sql.contains("SET @persona_1 = LAST_INSERT_ID()"), "Missing AUTO_INCREMENT variable assignment");
        // 변수 참조 확인
        assertTrue(sql.contains("WHERE id = @persona_1"), "Missing variable reference in WHERE clause");
        assertTrue(sql.contains("UPDATE persona SET sinner_id ="), "Should use snake_case: sinner_id");
        assertTrue(sql.contains("UPDATE persona SET grade = 'THREE'"));

        System.out.println("Generated SQL:");
        System.out.println(sql);
    }

    @Test
    void testPersonaWithResistance() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3

              resistance {
                slash WEAK,
                pierce NORMAL,
                blunt RESIST
              }
            }
            """;

        String sql = parseAndExport(lpdl);

        assertTrue(sql.contains("slash_resistance = 'WEAK'"));
        assertTrue(sql.contains("penetration_resistance = 'NORMAL'"));
        assertTrue(sql.contains("blunt_resistance = 'RESIST'"));

        System.out.println("Generated SQL:");
        System.out.println(sql);
    }

    @Test
    void testPersonaWithSpeed() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3

              speed {
                min 3,
                max 5
              }
            }
            """;

        String sql = parseAndExport(lpdl);

        assertTrue(sql.contains("min_speed = 3"));
        assertTrue(sql.contains("max_speed = 5"));

        System.out.println("Generated SQL:");
        System.out.println(sql);
    }

    @Test
    void testPersonaWithHealth() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3

              health {
                base 80,
                growth 7.5,
                disturbed [30, 50, 70]
              }
            }
            """;

        String sql = parseAndExport(lpdl);

        assertTrue(sql.contains("base_health = 80"));
        assertTrue(sql.contains("growth_rate = 7.5"));
        assertTrue(sql.contains("disturbed1 = 30"));
        assertTrue(sql.contains("disturbed2 = 50"));
        assertTrue(sql.contains("disturbed3 = 70"));

        System.out.println("Generated SQL:");
        System.out.println(sql);
    }

    @Test
    void testPersonaWithSkill() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3

              skill 1 "베기" {
                category ATTACK
                sin WRATH
                attack SLASH
                quantity 2
                keyword BLEED
              }
            }
            """;

        String sql = parseAndExport(lpdl);

        System.out.println("Generated SQL:");
        System.out.println(sql);

        assertTrue(sql.contains("INSERT INTO skill"), "Missing: INSERT INTO skill");
        assertTrue(sql.contains("skill_number"), "Missing: skill_number");
        assertTrue(sql.contains("'베기'"), "Missing: '베기'");
        // Skill FK는 persona 변수 참조
        assertTrue(sql.contains("persona_id, @persona_1") || sql.contains("@persona_1"), "Missing: persona FK reference");
        assertTrue(sql.contains("SET @skill_1 = LAST_INSERT_ID()"), "Missing: skill AUTO_INCREMENT variable");
        assertTrue(sql.contains("WHERE id = @skill_1"), "Missing: skill variable reference in WHERE");
        assertTrue(sql.contains("skill_category = 'ATTACK'"), "Missing: skill_category = 'ATTACK'");
        assertTrue(sql.contains("sin_affinity = 'WRATH'"), "Missing: sin_affinity = 'WRATH'");
        assertTrue(sql.contains("attack_type = 'SLASH'"), "Missing: attack_type = 'SLASH'");
        assertTrue(sql.contains("skill_quantity = 2"), "Missing: skill_quantity = 2");
        assertTrue(sql.contains("keyword_type = 'BLEED'"), "Missing: keyword_type = 'BLEED'");
    }

    @Test
    void testPersonaWithSkillAndSync() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3

              skill 1 "베기" {
                category ATTACK
                sin WRATH
                attack SLASH

                sync SYNC_4 {
                  basePower 5
                  coinPower 8
                  coinCount 3
                  weight 1
                  level 40
                }
              }
            }
            """;

        String sql = parseAndExport(lpdl);

        System.out.println("Generated SQL:");
        System.out.println(sql);
        System.out.println("\n=== Debug Info ===");
        System.out.println("SQL length: " + sql.length());
        System.out.println("Contains 'INSERT INTO skill_stats_by_sync': " + sql.contains("INSERT INTO skill_stats_by_sync"));
        System.out.println("Contains 'skill_stats_by_sync': " + sql.contains("skill_stats_by_sync"));
        System.out.println("SQL is null: " + (sql == null));

        assertTrue(sql.contains("INSERT INTO skill_stats_by_sync"), "Missing: INSERT INTO skill_stats_by_sync");
        // Sync FK는 skill 변수 참조
        assertTrue(sql.contains("@skill_1"), "Missing: skill FK reference");
        assertTrue(sql.contains("SET @skill_stats_by_sync_1 = LAST_INSERT_ID()"), "Missing: sync AUTO_INCREMENT variable");
        assertTrue(sql.contains("WHERE id = @skill_stats_by_sync_1"), "Missing: sync variable reference in WHERE");
        assertTrue(sql.contains("sync_level = 'SYNC_4'"));
        assertTrue(sql.contains("base_power = 5"));
        assertTrue(sql.contains("coin_power = 8"));
        assertTrue(sql.contains("coin_count = 3"));
        assertTrue(sql.contains("weight = 1"));
        assertTrue(sql.contains("level = 40"));
    }

    @Test
    void testMultiplePersonas() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3
            }

            persona "로쟈" {
              sinner "로쟈"
              grade 3
            }
            """;

        String sql = parseAndExport(lpdl);

        // 각 Persona마다 INSERT
        long personaCount = sql.lines()
            .filter(line -> line.contains("INSERT INTO persona"))
            .count();

        assertEquals(2, personaCount);

        System.out.println("Generated SQL:");
        System.out.println(sql);
    }

    @Test
    void testPersonaWithImage() {
        String lpdl = """
            persona "홍루" {
              sinner "홍루"
              grade 3

              image {
                type A,
                url "https://example.com/honglu.png",
                priority 1,
                primary true
              }
            }
            """;

        String sql = parseAndExport(lpdl);

        assertTrue(sql.contains("INSERT INTO persona_image"));
        // Image FK는 persona 변수 참조
        assertTrue(sql.contains("@persona_1"), "Missing: persona FK reference");
        assertTrue(sql.contains("SET @persona_image_1 = LAST_INSERT_ID()"), "Missing: image AUTO_INCREMENT variable");
        assertTrue(sql.contains("WHERE id = @persona_image_1"), "Missing: image variable reference in WHERE");
        assertTrue(sql.contains("type = 'A'"));
        assertTrue(sql.contains("url = 'https://example.com/honglu.png'"));
        assertTrue(sql.contains("priority = 1"));
        // MySQL Boolean은 1/0
        assertTrue(sql.contains("is_primary = 1"), "Boolean should be 1 (not TRUE) for MySQL");
        assertFalse(sql.contains("is_primary = TRUE"), "Boolean should not be TRUE for MySQL");

        System.out.println("Generated SQL:");
        System.out.println(sql);
    }

    @Test
    void testComplexPersonaWithEffectsCoinsAndPassive() {
        String lpdl = """
            persona "홍원 군주" {
                sinner "홍루"
                grade 3

                release "2025-08-14"

                skill 3 "오베르튀레" {
                    category ATTACK
                    sin LUST
                    attack BLUNT
                    keyword DEFAULT
                    image none

                    sync SYNC_4 {
                        basePower 4
                        coinPower 3
                        coinCount 4
                        weight 3
                        level 60

                        effect "[공격시] 자신 회복 5" {
                            trigger ON_HIT
                            self apply HP_HEAL +5
                        }

                        effect "[사용시] 대상에게 출혈 3" {
                            trigger ON_USE
                            target apply BLEED +3
                        }

                        effect "[공격 종료시] 자신 혈찬 10" {
                            trigger ON_ATTACK_END
                            self apply BLOOD_FEAST +10
                        }

                        coin 0 NORMAL {
                            text \"""
                            [적중시] 출혈 횟수 2 부여
                            \"""

                            effect "출혈 횟수 2" {
                                trigger ON_HIT
                                target apply BLEED_COUNT +2
                            }
                        }

                        coin 3 INVINCIBLE {
                            text \"""
                            [적중시] 라만차 퍼레이드 2 부여
                            \"""

                            effect "라만차 퍼레이드 2" {
                                trigger ON_HIT
                                target apply LAMANCHA_PAR +2
                            }
                        }
                    }
                }

                passive NORMAL "피의 연회" {
                    text \"""
                    턴 시작 시 출혈 부스트 2 부여
                    \"""

                    condition RESONATE sin LUST count 4
                }
            }
            """;

        String sql = parseAndExport(lpdl);

        System.out.println("\n=== Generated SQL for Complex Persona ===");
        System.out.println(sql);
        System.out.println("\n=== Verification ===");

        // Persona 기본 검증
        assertTrue(sql.contains("INSERT INTO persona"), "Missing: INSERT INTO persona");
        assertTrue(sql.contains("'홍원 군주'"), "Missing: persona name");
        assertTrue(sql.contains("sinner_id = 6"), "Missing: sinner ID");
        assertTrue(sql.contains("grade = 'THREE'"), "Missing: grade");
        assertTrue(sql.contains("release_date = '2025-08-14'"), "Missing: release date");

        // Skill 검증
        assertTrue(sql.contains("INSERT INTO skill"), "Missing: INSERT INTO skill");
        assertTrue(sql.contains("skill_number") && (sql.contains(", 3,") || sql.contains(", 3 ")), "Missing: skill number");
        assertTrue(sql.contains("'오베르튀레'"), "Missing: skill name");
        assertTrue(sql.contains("skill_category = 'ATTACK'"), "Missing: skill category");
        assertTrue(sql.contains("sin_affinity = 'LUST'"), "Missing: sin affinity");
        assertTrue(sql.contains("attack_type = 'BLUNT'"), "Missing: attack type");

        // Sync 검증
        assertTrue(sql.contains("INSERT INTO skill_stats_by_sync"), "Missing: INSERT INTO skill_stats_by_sync");
        assertTrue(sql.contains("sync_level = 'SYNC_4'"), "Missing: sync level");
        assertTrue(sql.contains("base_power = 4"), "Missing: base power");
        assertTrue(sql.contains("coin_power = 3"), "Missing: coin power");
        assertTrue(sql.contains("coin_count = 4"), "Missing: coin count");
        assertTrue(sql.contains("weight = 3"), "Missing: weight");
        assertTrue(sql.contains("level = 60"), "Missing: level");

        // Effect는 더 이상 파싱하지 않음 (RDB에서는 무시)
        // 대신 text description을 확인해야 함 (하지만 이 테스트에는 text가 없음)

        // Coin 검증
        assertTrue(sql.contains("INSERT INTO skill_coin"), "Missing: INSERT INTO skill_coin");
        assertTrue(sql.contains("order_index, 0") || sql.contains("order_index") && sql.contains(", 0"), "Missing: coin 0");
        assertTrue(sql.contains("order_index, 3") || sql.contains("order_index") && sql.contains(", 3"), "Missing: coin 3");
        assertTrue(sql.contains("NORMAL"), "Missing: NORMAL damage type");
        assertTrue(sql.contains("INVINCIBLE"), "Missing: INVINCIBLE damage type");

        // Coin Effect는 더 이상 파싱하지 않음 (text 블록 사용)

        // Passive 검증
        assertTrue(sql.contains("INSERT INTO persona_passive"), "Missing: INSERT INTO persona_passive");
        assertTrue(sql.contains("kind") && sql.contains("'NORMAL'"), "Missing: kind = NORMAL");
        assertTrue(sql.contains("'피의 연회'"), "Missing: passive name");

        // AUTO_INCREMENT 변수 검증
        assertTrue(sql.contains("SET @persona_1 = LAST_INSERT_ID()"), "Missing: persona AUTO_INCREMENT");
        assertTrue(sql.contains("SET @skill_1 = LAST_INSERT_ID()"), "Missing: skill AUTO_INCREMENT");
        assertTrue(sql.contains("SET @skill_stats_by_sync_1 = LAST_INSERT_ID()"), "Missing: sync AUTO_INCREMENT");
        assertTrue(sql.contains("SET @skill_coin_"), "Missing: coin AUTO_INCREMENT");
        assertTrue(sql.contains("SET @persona_passive_"), "Missing: passive AUTO_INCREMENT");

        // FK 참조 검증
        assertTrue(sql.contains("@persona_1"), "Missing: persona FK reference");
        assertTrue(sql.contains("@skill_1"), "Missing: skill FK reference");
        assertTrue(sql.contains("@skill_stats_by_sync_1"), "Missing: sync FK reference");
    }

    private String parseAndExport(String lpdlCode) {
        try {
            // ANTLR 파싱
            CharStream input = CharStreams.fromString(lpdlCode);
            LPDLLexer lexer = new LPDLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LPDLParser parser = new LPDLParser(tokens);

            // 파싱 에러 체크
            parser.removeErrorListeners();
            parser.addErrorListener(new org.antlr.v4.runtime.BaseErrorListener() {
                @Override
                public void syntaxError(org.antlr.v4.runtime.Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line,
                                        int charPositionInLine,
                                        String msg,
                                        org.antlr.v4.runtime.RecognitionException e) {
                    throw new RuntimeException(
                        String.format("Syntax error at line %d:%d - %s", line, charPositionInLine, msg)
                    );
                }
            });

            LPDLParser.ProgramContext programCtx = parser.program();

            // SQL 변환
            RDBExporter exporter = new RDBExporter();
            return exporter.export(programCtx);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Parsing or export failed: " + e.getMessage());
            return null;
        }
    }
}
