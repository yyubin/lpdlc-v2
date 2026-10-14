package org.yyubin.lpdl.exporter;

import org.antlr.v4.runtime.tree.ParseTree;
import org.yyubin.lpdl.exporter.sql.SQLGenerator;
import org.yyubin.lpdl.exporter.sql.SQLVariable;
import org.yyubin.lpdl.exporter.util.ExporterContext;
import org.yyubin.lpdl.exporter.util.IDManager;
import org.yyubin.lpdl.parser.LPDLBaseVisitor;
import org.yyubin.lpdl.parser.LPDLParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * LPDL AST를 RDB SQL로 변환하는 Exporter
 *
 * ANTLR Visitor 패턴을 사용하여 AST를 순회하면서
 * 즉시 SQL INSERT/UPDATE 문을 생성합니다.
 */
public class RDBExporter extends LPDLBaseVisitor<Void> {

    private final SQLGenerator sqlGenerator;
    private final IDManager idManager;
    private final ExporterContext context;

    public RDBExporter() {
        this.sqlGenerator = new SQLGenerator();
        this.idManager = new IDManager();
        this.context = new ExporterContext();
    }

    /**
     * LPDL 프로그램을 SQL로 변환
     *
     * @param programCtx ANTLR ParseTree 루트
     * @return 생성된 SQL 문자열
     */
    public String export(LPDLParser.ProgramContext programCtx) {
        // 리셋
        sqlGenerator.clear();
        idManager.resetAll();
        context.reset();

        // AST 순회
        visit(programCtx);

        return sqlGenerator.generateAll();
    }

    /**
     * SQL을 파일로 저장
     */
    public void exportToFile(LPDLParser.ProgramContext programCtx, Path outputPath) throws IOException {
        export(programCtx);
        sqlGenerator.writeToFile(outputPath);
    }

    /**
     * 생성된 SQL 문 개수
     */
    public int getGeneratedStatementCount() {
        return sqlGenerator.getStatementCount();
    }

    // ═══════════════════════════════════════════════════════════════
    // PERSONA
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitPersonaDecl(LPDLParser.PersonaDeclContext ctx) {
        long personaId = idManager.nextId("persona");
        String personaVar = "persona_" + personaId;
        context.enterPersona(personaId);

        // Persona 이름
        String name = extractString(ctx.stringLiteral());

        // INSERT persona (id는 AUTO_INCREMENT)
        sqlGenerator.insert("persona")
            .value("name", name)
            .generateWithAutoId(personaVar);

        // persona body 순회
        if (ctx.personaBody() != null) {
            for (var stmt : ctx.personaBody().personaStmt()) {
                visit(stmt);
            }
        }

        // Season이 설정되지 않았으면 기본값(NORMAL, 0) 설정
        if (!context.isSeasonSet(personaId)) {
            sqlGenerator.update("persona")
                .set("season_type", "NORMAL")
                .set("season_number", 0)
                .where("id", new SQLVariable(personaVar))
                .generate();
        }

        context.exitPersona();
        return null;
    }

    private static final Map<String, Integer> SINNER_ID_MAP = Map.ofEntries(
            Map.entry("이상", 1),
            Map.entry("파우스트", 2),
            Map.entry("돈키호테", 3),
            Map.entry("료슈", 4),
            Map.entry("뫼르소", 5),
            Map.entry("홍루", 6),
            Map.entry("히스클리프", 7),
            Map.entry("이스마엘", 8),
            Map.entry("로쟈", 9),
            Map.entry("싱클레어", 10),
            Map.entry("오티스", 11),
            Map.entry("그레고르", 12)
    );

    @Override
    public Void visitSinnerStmt(LPDLParser.SinnerStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);

        String sinnerName = ctx.stringLiteral() != null
                ? extractString(ctx.stringLiteral())
                : ctx.IDENT().getText();

        Integer sinnerId = SINNER_ID_MAP.get(sinnerName);
        if (sinnerId == null) {
            throw new IllegalArgumentException("Unknown sinner name: " + sinnerName);
        }

        sqlGenerator.update("persona")
                .set("sinner_id", sinnerId)
                .where("id", personaVar)
                .generate();

        return null;
    }

    @Override
    public Void visitGradeStmt(LPDLParser.GradeStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);
        String grade = parseGrade(ctx.gradeValue());

        sqlGenerator.update("persona")
            .set("grade", grade)
            .where("id", personaVar)
            .generate();

        return null;
    }

    @Override
    public Void visitSinStmt(LPDLParser.SinStmtContext ctx) {
        // Persona 레벨의 sin은 JPA에 없으므로 무시
        // (대표 스킬의 sin 속성으로 대체)
        return null;
    }

    @Override
    public Void visitReleaseStmt(LPDLParser.ReleaseStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);
        String releaseDate = extractString(ctx.stringLiteral());

        sqlGenerator.update("persona")
            .set("release_date", releaseDate)
            .where("id", personaVar)
            .generate();

        return null;
    }

    @Override
    public Void visitMaxLevelStmt(LPDLParser.MaxLevelStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);
        int maxLevel = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("persona")
            .set("max_level", maxLevel)
            .where("id", personaVar)
            .generate();

        return null;
    }

    @Override
    public Void visitDefenseLevelStmt(LPDLParser.DefenseLevelStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);
        int defenseLevel = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("persona")
            .set("defense_level", defenseLevel)
            .where("id", personaVar)
            .generate();

        return null;
    }

    @Override
    public Void visitResistanceStmt(LPDLParser.ResistanceStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);

        Map<String, String> resistances = new HashMap<>();
        for (var pair : ctx.resistancePair()) {
            String type = pair.IDENT(0).getText(); // slash, pierce, blunt
            String value = pair.IDENT(1).getText(); // WEAK, NORMAL, RESIST
            resistances.put(type, value);
        }

        // Embedded 필드 업데이트
        sqlGenerator.update("persona")
            .set("slash_resistance", resistances.getOrDefault("slash", "NORMAL"))
            .set("penetration_resistance", resistances.getOrDefault("pierce", "NORMAL"))
            .set("blunt_resistance", resistances.getOrDefault("blunt", "NORMAL"))
            .where("id", personaVar)
            .generate();

        return null;
    }

    @Override
    public Void visitSpeedStmt(LPDLParser.SpeedStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);

        Map<String, Integer> speeds = new HashMap<>();
        for (var pair : ctx.speedPair()) {
            String key = pair.IDENT().getText(); // min, max
            int value = Integer.parseInt(pair.INT().getText());
            speeds.put(key, value);
        }

        sqlGenerator.update("persona")
            .set("min_speed", speeds.getOrDefault("min", 1))
            .set("max_speed", speeds.getOrDefault("max", 5))
            .where("id", personaVar)
            .generate();

        return null;
    }

    @Override
    public Void visitHealthStmt(LPDLParser.HealthStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);

        Map<String, Object> health = new HashMap<>();

        for (var field : ctx.healthField()) {
            if (field.BASE() != null) {
                health.put("base_health", Integer.parseInt(field.INT(0).getText()));
            } else if (field.GROWTH() != null) {
                health.put("growth_rate", parseNumber(field.numberLiteral()));
            } else if (field.DISTURBED() != null) {
                // disturbed [30, 50, 70]
                var ints = field.INT();
                if (ints.size() >= 1) health.put("disturbed1", Integer.parseInt(ints.get(0).getText()));
                if (ints.size() >= 2) health.put("disturbed2", Integer.parseInt(ints.get(1).getText()));
                if (ints.size() >= 3) health.put("disturbed3", Integer.parseInt(ints.get(2).getText()));
            }
        }

        var updateBuilder = sqlGenerator.update("persona");
        health.forEach(updateBuilder::set);
        updateBuilder.where("id", personaVar).generate();

        return null;
    }

    @Override
    public Void visitSeasonStmt(LPDLParser.SeasonStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);

        Map<String, Object> season = new HashMap<>();
        for (var field : ctx.seasonField()) {
            if (field.TYPE() != null) {
                season.put("season_type", field.IDENT().getText());
            } else if (field.NUMBER() != null) {
                season.put("season_number", Integer.parseInt(field.INT().getText()));
            }
        }

        var updateBuilder = sqlGenerator.update("persona");
        season.forEach(updateBuilder::set);
        updateBuilder.where("id", personaVar).generate();

        // Season이 설정되었음을 표시
        context.setSeasonSet(personaId);

        return null;
    }

    @Override
    public Void visitImageDecl(LPDLParser.ImageDeclContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);
        long imageId = idManager.nextId("persona_image");
        String imageVar = "persona_image_" + imageId;

        // INSERT with minimal fields (id는 AUTO_INCREMENT)
        sqlGenerator.insert("persona_image")
            .value("persona_id", personaVar)
            .generateWithAutoId(imageVar);

        // UPDATE for each field
        SQLVariable imageVarObj = new SQLVariable(imageVar);
        for (var field : ctx.imageField()) {
            if (field.TYPE() != null) {
                sqlGenerator.update("persona_image")
                    .set("type", field.IDENT().getText())
                    .where("id", imageVarObj)
                    .generate();
            } else if (field.URL() != null) {
                sqlGenerator.update("persona_image")
                    .set("url", extractString(field.stringLiteral()))
                    .where("id", imageVarObj)
                    .generate();
            } else if (field.PRIORITY() != null) {
                sqlGenerator.update("persona_image")
                    .set("priority", Integer.parseInt(field.INT().getText()))
                    .where("id", imageVarObj)
                    .generate();
            } else if (field.PRIMARY() != null) {
                sqlGenerator.update("persona_image")
                    .set("is_primary", parseBool(field.booleanLiteral()))
                    .where("id", imageVarObj)
                    .generate();
            }
        }

        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // SKILL
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitSkillDecl(LPDLParser.SkillDeclContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);
        long skillId = idManager.nextId("skill");
        String skillVar = "skill_" + skillId;
        context.enterSkill(skillId);

        int skillNumber = Integer.parseInt(ctx.INT().getText());
        String skillName = ctx.stringLiteral() != null
            ? extractString(ctx.stringLiteral())
            : "";

        // INSERT skill (id는 AUTO_INCREMENT)
        sqlGenerator.insert("skill")
            .value("persona_id", personaVar)
            .value("skill_number", skillNumber)
            .value("name", skillName)
            .generateWithAutoId(skillVar);

        // skill body 순회
        if (ctx.skillBody() != null) {
            for (var stmt : ctx.skillBody().skillStmt()) {
                visit(stmt);
            }
        }

        context.exitSkill();
        return null;
    }

    @Override
    public Void visitCategoryStmt(LPDLParser.CategoryStmtContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);
        String category = ctx.IDENT().getText();

        sqlGenerator.update("skill")
            .set("skill_category", category)
            .where("id", skillVar)
            .generate();

        return null;
    }

    @Override
    public Void visitSkillSinStmt(LPDLParser.SkillSinStmtContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);
        String sin = ctx.sinAffinityType().getText();

        sqlGenerator.update("skill")
            .set("sin_affinity", sin)
            .where("id", skillVar)
            .generate();

        return null;
    }

    @Override
    public Void visitAttackStmt(LPDLParser.AttackStmtContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);
        String attackType = ctx.IDENT().getText();

        sqlGenerator.update("skill")
            .set("attack_type", attackType)
            .where("id", skillVar)
            .generate();

        return null;
    }

    @Override
    public Void visitDefenseStmt(LPDLParser.DefenseStmtContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);
        String defenseType = ctx.IDENT().getText();

        sqlGenerator.update("skill")
            .set("defense_type", defenseType)
            .where("id", skillVar)
            .generate();

        return null;
    }

    @Override
    public Void visitQuantityStmt(LPDLParser.QuantityStmtContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);
        int quantity = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("skill")
            .set("skill_quantity", quantity)
            .where("id", skillVar)
            .generate();

        return null;
    }

    @Override
    public Void visitKeywordStmt(LPDLParser.KeywordStmtContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);
        String keyword = ctx.IDENT().getText();

        sqlGenerator.update("skill")
            .set("keyword_type", keyword)
            .where("id", skillVar)
            .generate();

        return null;
    }

    @Override
    public Void visitImageStmt(LPDLParser.ImageStmtContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);

        String image = null;
        if (ctx.stringLiteral() != null) {
            image = extractString(ctx.stringLiteral());
        } else if (ctx.IDENT() != null) {
            image = ctx.IDENT().getText();
        } else if (ctx.NONE() != null) {
            image = null;
        }

        sqlGenerator.update("skill")
            .set("skill_image", image)
            .where("id", skillVar)
            .generate();

        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // SYNC
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitSyncDecl(LPDLParser.SyncDeclContext ctx) {
        long skillId = context.getCurrentSkillId();
        SQLVariable skillVar = new SQLVariable("skill_" + skillId);
        long syncId = idManager.nextId("skill_stats_by_sync");
        String syncVar = "skill_stats_by_sync_" + syncId;
        context.enterSync(syncId);

        String syncLevel = parseSyncLevel(ctx.syncLevel());

        // INSERT with minimal fields (id는 AUTO_INCREMENT)
        sqlGenerator.insert("skill_stats_by_sync")
            .value("skill_id", skillVar)
            .generateWithAutoId(syncVar);

        // UPDATE to set syncLevel
        SQLVariable syncVarObj = new SQLVariable(syncVar);
        sqlGenerator.update("skill_stats_by_sync")
            .set("sync_level", syncLevel)
            .where("id", syncVarObj)
            .generate();

        // sync body 순회
        if (ctx.syncBody() != null) {
            for (var stmt : ctx.syncBody().syncStmt()) {
                visit(stmt);
            }
        }

        context.exitSync();
        return null;
    }

    @Override
    public Void visitBasePowerStmt(LPDLParser.BasePowerStmtContext ctx) {
        long syncId = context.getCurrentSyncId();
        SQLVariable syncVar = new SQLVariable("skill_stats_by_sync_" + syncId);
        int basePower = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("skill_stats_by_sync")
            .set("base_power", basePower)
            .where("id", syncVar)
            .generate();

        return null;
    }

    @Override
    public Void visitCoinPowerStmt(LPDLParser.CoinPowerStmtContext ctx) {
        long syncId = context.getCurrentSyncId();
        SQLVariable syncVar = new SQLVariable("skill_stats_by_sync_" + syncId);
        int coinPower = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("skill_stats_by_sync")
            .set("coin_power", coinPower)
            .where("id", syncVar)
            .generate();

        return null;
    }

    @Override
    public Void visitCoinCountStmt(LPDLParser.CoinCountStmtContext ctx) {
        long syncId = context.getCurrentSyncId();
        SQLVariable syncVar = new SQLVariable("skill_stats_by_sync_" + syncId);
        int coinCount = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("skill_stats_by_sync")
            .set("coin_count", coinCount)
            .where("id", syncVar)
            .generate();

        return null;
    }

    @Override
    public Void visitWeightStmt(LPDLParser.WeightStmtContext ctx) {
        long syncId = context.getCurrentSyncId();
        SQLVariable syncVar = new SQLVariable("skill_stats_by_sync_" + syncId);
        int weight = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("skill_stats_by_sync")
            .set("weight", weight)
            .where("id", syncVar)
            .generate();

        return null;
    }

    @Override
    public Void visitLevelStmt(LPDLParser.LevelStmtContext ctx) {
        long syncId = context.getCurrentSyncId();
        SQLVariable syncVar = new SQLVariable("skill_stats_by_sync_" + syncId);
        int level = Integer.parseInt(ctx.INT().getText());

        sqlGenerator.update("skill_stats_by_sync")
            .set("level", level)
            .where("id", syncVar)
            .generate();

        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // TEXT DECLARATION (원문 텍스트 저장)
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitTextDecl(LPDLParser.TextDeclContext ctx) {
        String originalText = extractTripleString(ctx.tripleStringLiteral());

        // Context에 따라 다른 테이블에 저장
        if (context.hasCoin()) {
            // Coin 내부의 text
            long coinId = context.getCurrentCoinId();
            SQLVariable coinVar = new SQLVariable("skill_coin_" + coinId);
            long descId = idManager.nextId("coin_description");
            String descVar = "coin_description_" + descId;

            sqlGenerator.insert("coin_description")
                .value("skill_coin_id", coinVar)
                .value("original_text", originalText)
                .generateWithAutoId(descVar);
        } else if (context.hasSync()) {
            // Sync 레벨 내부의 text (스킬 설명)
            long syncId = context.getCurrentSyncId();
            SQLVariable syncVar = new SQLVariable("skill_stats_by_sync_" + syncId);
            long descId = idManager.nextId("skill_description");
            String descVar = "skill_description_" + descId;

            sqlGenerator.insert("skill_description")
                .value("stats_by_sync_id", syncVar)
                .value("original_text", originalText)
                .generateWithAutoId(descVar);
        }
        // passive의 text는 visitPassiveDecl에서 처리

        return null;
    }

    // Effect와 Action 관련 visitor는 제거하고 무시하도록 처리
    @Override
    public Void visitEffectDecl(LPDLParser.EffectDeclContext ctx) {
        // Effect는 RDB에서 파싱하지 않고 무시
        // (Neo4j에서만 처리 예정)
        return null;
    }

    @Override
    public Void visitTriggerStmt(LPDLParser.TriggerStmtContext ctx) {
        // 무시
        return null;
    }

    @Override
    public Void visitActionSimple(LPDLParser.ActionSimpleContext ctx) {
        // 무시
        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // COIN
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitCoinDecl(LPDLParser.CoinDeclContext ctx) {
        long syncId = context.getCurrentSyncId();
        SQLVariable syncVar = new SQLVariable("skill_stats_by_sync_" + syncId);
        long coinId = idManager.nextId("skill_coin");
        String coinVar = "skill_coin_" + coinId;
        context.enterCoin(coinId);

        int coinNumber = Integer.parseInt(ctx.INT().getText());
        String damageType = ctx.IDENT().getText(); // NORMAL, INVINCIBLE, etc.

        // INSERT skill_coin (id는 AUTO_INCREMENT)
        sqlGenerator.insert("skill_coin")
            .value("stats_by_sync_id", syncVar)
            .value("order_index", coinNumber)
            .value("coin_type", damageType)
            .generateWithAutoId(coinVar);

        // coin body 순회 (text와 effect를 개별 방문)
        if (ctx.coinBody() != null) {
            // text 방문
            if (ctx.coinBody().textDecl() != null) {
                visit(ctx.coinBody().textDecl());
            }
            // effect들 방문 (effectInlineDecl은 RDB에서 무시됨)
            for (var effect : ctx.coinBody().effectInlineDecl()) {
                visit(effect);
            }
        }

        context.exitCoin();
        return null;
    }

    @Override
    public Void visitEffectInlineDecl(LPDLParser.EffectInlineDeclContext ctx) {
        // Effect는 RDB에서 파싱하지 않고 무시
        // text 블록을 사용하여 원문을 저장하도록 변경
        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // PASSIVE
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitPassiveDecl(LPDLParser.PassiveDeclContext ctx) {
        long personaId = context.getCurrentPersonaId();
        SQLVariable personaVar = new SQLVariable("persona_" + personaId);
        long passiveId = idManager.nextId("persona_passive");
        String passiveVar = "persona_passive_" + passiveId;
        context.enterPassive(passiveId);

        String kind = ctx.IDENT().getText(); // NORMAL, SUPPORT

        // Passive name
        String passiveName = "";
        if (ctx.stringLiteral() != null) {
            passiveName = extractString(ctx.stringLiteral());
        }

        // Passive 조건 필드들
        String conditionType = null;
        String conditionSin = null;
        Integer conditionCount = null;
        String syncLevel = null;

        // passive body 순회 - text, condition, syncLevel 처리
        if (ctx.passiveBody() != null) {
            for (var stmt : ctx.passiveBody().passiveStmt()) {
                if (stmt.textDecl() != null) {
                    // passive_description 테이블에 저장 (나중에 처리)
                } else if (stmt.passiveConditionStmt() != null) {
                    // condition HOLD sin WRATH count 3
                    var condStmt = stmt.passiveConditionStmt();
                    conditionType = condStmt.IDENT().getText();  // HOLD, RESONATE
                    conditionSin = condStmt.sinAffinityType().getText();  // WRATH, LUST...
                    if (condStmt.INT() != null) {
                        conditionCount = Integer.parseInt(condStmt.INT().getText());
                    }
                } else if (stmt.passiveSyncLevelStmt() != null) {
                    // syncLevel SYNC_3
                    syncLevel = stmt.passiveSyncLevelStmt().IDENT().getText();  // SYNC_1, SYNC_2...
                }
                // 다른 stmt는 무시 (trigger, action 등은 RDB에서 저장 안 함)
            }
        }

        // INSERT persona_passive (id는 AUTO_INCREMENT)
        sqlGenerator.insert("persona_passive")
            .value("persona_id", personaVar)
            .value("kind", kind)
            .value("name", passiveName)
            .value("condition_type", conditionType)
            .value("condition_sin_affinity", conditionSin)
            .value("condition_count", conditionCount)
            .value("sync_level", syncLevel)
            .generateWithAutoId(passiveVar);

        // text 처리 - passive_description에 저장
        if (ctx.passiveBody() != null) {
            for (var stmt : ctx.passiveBody().passiveStmt()) {
                if (stmt.textDecl() != null) {
                    String originalText = extractTripleString(stmt.textDecl().tripleStringLiteral());
                    long descId = idManager.nextId("passive_description");
                    String descVar = "passive_description_" + descId;

                    sqlGenerator.insert("passive_description")
                        .value("persona_passive_id", new SQLVariable(passiveVar))
                        .value("original_text", originalText)
                        .generateWithAutoId(descVar);
                }
            }
        }

        context.exitPassive();
        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // 유틸리티 메서드
    // ═══════════════════════════════════════════════════════════════

    /**
     * 문자열 리터럴 추출 (따옴표 제거 및 이스케이프 처리)
     */
    private String extractString(LPDLParser.StringLiteralContext ctx) {
        if (ctx == null || ctx.STRING() == null) {
            return "";
        }

        String raw = ctx.STRING().getText();
        // 앞뒤 따옴표 제거
        String unquoted = raw.substring(1, raw.length() - 1);

        // 이스케이프 처리
        return unquoted
            .replace("\\\"", "\"")
            .replace("\\\\", "\\")
            .replace("\\n", "\n")
            .replace("\\t", "\t");
    }

    /**
     * 트리플 스트링 리터럴 추출 (""" ... """ 제거 및 이스케이프 처리)
     */
    private String extractTripleString(LPDLParser.TripleStringLiteralContext ctx) {
        if (ctx == null || ctx.TRIPLE_STRING() == null) {
            return "";
        }

        String raw = ctx.TRIPLE_STRING().getText();
        // 앞뒤 """ 제거
        String unquoted = raw.substring(3, raw.length() - 3);

        // 이스케이프 처리
        return unquoted
            .replace("\\\"", "\"")
            .replace("\\\\", "\\")
            .replace("\\n", "\n")
            .replace("\\t", "\t");
    }

    /**
     * Grade 파싱
     */
    private String parseGrade(LPDLParser.GradeValueContext ctx) {
        if (ctx.INT() != null) {
            int grade = Integer.parseInt(ctx.INT().getText());
            return switch (grade) {
                case 1 -> "ONE";
                case 2 -> "TWO";
                case 3 -> "THREE";
                default -> throw new IllegalArgumentException("Invalid grade: " + grade);
            };
        } else if (ctx.IDENT() != null) {
            return ctx.IDENT().getText().toUpperCase();
        }
        throw new IllegalArgumentException("Invalid grade value");
    }

    /**
     * Sync Level 파싱
     */
    private String parseSyncLevel(LPDLParser.SyncLevelContext ctx) {
        if (ctx.IDENT() != null) {
            return ctx.IDENT().getText();
        } else if (ctx.STRING() != null) {
            String raw = ctx.STRING().getText();
            return raw.substring(1, raw.length() - 1);
        }
        throw new IllegalArgumentException("Invalid sync level");
    }

    /**
     * Number 리터럴 파싱
     */
    private double parseNumber(LPDLParser.NumberLiteralContext ctx) {
        if (ctx.FLOAT() != null) {
            return Double.parseDouble(ctx.FLOAT().getText());
        } else if (ctx.INT() != null) {
            return Integer.parseInt(ctx.INT().getText());
        }
        return 0.0;
    }

    /**
     * Boolean 리터럴 파싱
     */
    private boolean parseBool(LPDLParser.BooleanLiteralContext ctx) {
        return ctx.TRUE() != null;
    }
}
