package org.yyubin.lpdl.exporter;

import org.yyubin.lpdl.exporter.cypher.CypherQueryGenerator;
import org.yyubin.lpdl.exporter.util.ExporterContext;
import org.yyubin.lpdl.parser.LPDLBaseVisitor;
import org.yyubin.lpdl.parser.LPDLParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * LPDL AST를 Neo4j Cypher 쿼리로 변환하는 Exporter
 *
 * 그래프 DB 구조:
 * - Persona 노드: 인격 정보
 * - Skill 노드: 스킬 정보
 * - Passive 노드: 패시브 정보
 * - (Persona)-[:HAS_SKILL]->(Skill)
 * - (Persona)-[:HAS_PASSIVE]->(Passive)
 */
public class Neo4jExporter extends LPDLBaseVisitor<Void> {

    private final CypherQueryGenerator cypherGenerator;
    private final ExporterContext context;
    private final Map<String, String> variableMap;  // ID -> 변수명 매핑
    private int variableCounter;

    public Neo4jExporter() {
        this.cypherGenerator = new CypherQueryGenerator();
        this.context = new ExporterContext();
        this.variableMap = new HashMap<>();
        this.variableCounter = 0;
    }

    /**
     * LPDL 프로그램을 Cypher 쿼리로 변환
     *
     * @param programCtx ANTLR ParseTree 루트
     * @return 생성된 Cypher 쿼리 문자열
     */
    public String export(LPDLParser.ProgramContext programCtx) {
        // 리셋
        cypherGenerator.clear();
        context.reset();
        variableMap.clear();
        variableCounter = 0;

        // AST 순회
        visit(programCtx);

        return cypherGenerator.generateAll();
    }

    /**
     * Cypher 쿼리를 파일로 저장
     */
    public void exportToFile(LPDLParser.ProgramContext programCtx, Path outputPath) throws IOException {
        export(programCtx);
        cypherGenerator.writeToFile(outputPath);
    }

    /**
     * 생성된 쿼리 개수
     */
    public int getGeneratedStatementCount() {
        return cypherGenerator.getStatementCount();
    }

    /**
     * 고유한 변수명 생성
     */
    private String generateVariable(String prefix) {
        return prefix + (++variableCounter);
    }

    /**
     * 문자열 리터럴 추출
     */
    private String extractString(LPDLParser.StringLiteralContext ctx) {
        if (ctx == null || ctx.STRING() == null) {
            return "";
        }
        String raw = ctx.STRING().getText();
        // 앞뒤 따옴표 제거
        if (raw.length() >= 2 && raw.startsWith("\"") && raw.endsWith("\"")) {
            return raw.substring(1, raw.length() - 1);
        }
        return raw;
    }

    // ═══════════════════════════════════════════════════════════════
    // PERSONA
    // ═══════════════════════════════════════════════════════════════

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
            Map.entry("그레고르", 12),
            Map.entry("단테", 13)
    );

    @Override
    public Void visitPersonaDecl(LPDLParser.PersonaDeclContext ctx) {
        String personaVar = generateVariable("p");
        String name = extractString(ctx.stringLiteral());

        // Persona 노드 생성
        cypherGenerator.createNode("Persona", personaVar)
            .property("name", name)
            .generate();

        // 변수 저장
        long personaId = variableCounter;
        variableMap.put("persona_" + personaId, personaVar);
        context.enterPersona(personaId);

        // persona body 순회
        if (ctx.personaBody() != null) {
            for (var stmt : ctx.personaBody().personaStmt()) {
                visit(stmt);
            }
        }

        // Season이 설정되지 않았으면 기본값 추가 (주석)
        if (!context.isSeasonSet(personaId)) {
            cypherGenerator.addStatement(
                "// SET " + personaVar + ".season_type = 'NORMAL', " +
                personaVar + ".season_number = 0"
            );
        }

        context.exitPersona();
        return null;
    }

    @Override
    public Void visitSinnerStmt(LPDLParser.SinnerStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        String sinnerName;
        if (ctx.stringLiteral() != null) {
            sinnerName = extractString(ctx.stringLiteral());
        } else if (ctx.IDENT() != null) {
            sinnerName = ctx.IDENT().getText();
        } else {
            return null;
        }

        Integer sinnerId = SINNER_ID_MAP.get(sinnerName);
        cypherGenerator.addStatement(
            "SET " + personaVar + ".sinner = '" + sinnerName + "'" +
            (sinnerId != null ? ", " + personaVar + ".sinner_id = " + sinnerId : "")
        );

        return null;
    }

    @Override
    public Void visitGradeStmt(LPDLParser.GradeStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        String gradeValue;
        if (ctx.gradeValue().INT() != null) {
            int grade = Integer.parseInt(ctx.gradeValue().INT().getText());
            gradeValue = switch (grade) {
                case 1 -> "ONE";
                case 2 -> "TWO";
                case 3 -> "THREE";
                default -> "UNKNOWN";
            };
        } else if (ctx.gradeValue().IDENT() != null) {
            gradeValue = ctx.gradeValue().IDENT().getText();
        } else {
            gradeValue = "UNKNOWN";
        }

        cypherGenerator.addStatement(
            "SET " + personaVar + ".grade = '" + gradeValue + "'"
        );

        return null;
    }

    @Override
    public Void visitReleaseStmt(LPDLParser.ReleaseStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);
        String releaseDate = extractString(ctx.stringLiteral());

        cypherGenerator.addStatement(
            "SET " + personaVar + ".release_date = '" + releaseDate + "'"
        );

        return null;
    }

    @Override
    public Void visitMaxLevelStmt(LPDLParser.MaxLevelStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);
        int maxLevel = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + personaVar + ".max_level = " + maxLevel
        );

        return null;
    }

    @Override
    public Void visitDefenseLevelStmt(LPDLParser.DefenseLevelStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);
        int defenseLevel = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + personaVar + ".defense_level = " + defenseLevel
        );

        return null;
    }

    @Override
    public Void visitResistanceStmt(LPDLParser.ResistanceStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        Map<String, String> resistances = new java.util.HashMap<>();
        for (var pair : ctx.resistancePair()) {
            String type = pair.IDENT(0).getText(); // slash, pierce, blunt
            String value = pair.IDENT(1).getText(); // WEAK, NORMAL, RESIST
            resistances.put(type, value);
        }

        StringBuilder sb = new StringBuilder("SET ");
        sb.append(personaVar).append(".res_slash = '")
          .append(resistances.getOrDefault("slash", "NORMAL")).append("', ");
        sb.append(personaVar).append(".res_pierce = '")
          .append(resistances.getOrDefault("pierce", "NORMAL")).append("', ");
        sb.append(personaVar).append(".res_blunt = '")
          .append(resistances.getOrDefault("blunt", "NORMAL")).append("'");

        cypherGenerator.addStatement(sb.toString());

        return null;
    }

    @Override
    public Void visitSpeedStmt(LPDLParser.SpeedStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        Map<String, Integer> speeds = new java.util.HashMap<>();
        for (var pair : ctx.speedPair()) {
            String key = pair.IDENT().getText(); // min, max
            int value = Integer.parseInt(pair.INT().getText());
            speeds.put(key, value);
        }

        cypherGenerator.addStatement(
            "SET " + personaVar + ".min_speed = " + speeds.getOrDefault("min", 1) +
            ", " + personaVar + ".max_speed = " + speeds.getOrDefault("max", 5)
        );

        return null;
    }

    @Override
    public Void visitHealthStmt(LPDLParser.HealthStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        Integer baseHealth = null;
        Double growthRate = null;
        java.util.List<Integer> disturbedLevels = new java.util.ArrayList<>();

        for (var field : ctx.healthField()) {
            if (field.BASE() != null) {
                baseHealth = Integer.parseInt(field.INT(0).getText());
            } else if (field.GROWTH() != null) {
                // Parse number literal (can be int or double)
                String numStr = field.numberLiteral().getText();
                growthRate = Double.parseDouble(numStr);
            } else if (field.DISTURBED() != null) {
                // disturbed [60, 30]
                for (var intNode : field.INT()) {
                    disturbedLevels.add(Integer.parseInt(intNode.getText()));
                }
            }
        }

        StringBuilder sb = new StringBuilder("SET ");
        if (baseHealth != null) {
            sb.append(personaVar).append(".base_health = ").append(baseHealth);
        }
        if (growthRate != null) {
            if (baseHealth != null) sb.append(", ");
            sb.append(personaVar).append(".growth_rate = ").append(growthRate);
        }
        if (!disturbedLevels.isEmpty()) {
            if (baseHealth != null || growthRate != null) sb.append(", ");
            sb.append(personaVar).append(".disturbed_levels = [");
            sb.append(disturbedLevels.stream()
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining(", ")));
            sb.append("]");
        }

        cypherGenerator.addStatement(sb.toString());

        return null;
    }

    @Override
    public Void visitSeasonStmt(LPDLParser.SeasonStmtContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        Map<String, Object> season = new HashMap<>();
        for (var field : ctx.seasonField()) {
            if (field.TYPE() != null) {
                season.put("season_type", field.IDENT().getText());
            } else if (field.NUMBER() != null) {
                season.put("season_number", Integer.parseInt(field.INT().getText()));
            }
        }

        StringBuilder sb = new StringBuilder("SET ");
        sb.append(personaVar).append(".season_type = '")
          .append(season.getOrDefault("season_type", "NORMAL")).append("', ");
        sb.append(personaVar).append(".season_number = ")
          .append(season.getOrDefault("season_number", 0));

        cypherGenerator.addStatement(sb.toString());
        context.setSeasonSet(personaId);

        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // SKILL
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitSkillDecl(LPDLParser.SkillDeclContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        // Skill 변수 생성
        String skillVar = generateVariable("s");
        long skillId = variableCounter;
        variableMap.put("skill_" + skillId, skillVar);
        context.enterSkill(skillId);

        // Skill 번호와 이름
        int skillNumber = Integer.parseInt(ctx.INT().getText());
        String skillName = ctx.stringLiteral() != null ?
                          extractString(ctx.stringLiteral()) : "Skill " + skillNumber;

        // Skill 노드 생성
        cypherGenerator.createNode("Skill", skillVar)
            .property("name", skillName)
            .property("skill_number", skillNumber)
            .generate();

        // Persona-[HAS_SKILL]->Skill 관계 생성
        cypherGenerator.createRelationship(personaVar, "HAS_SKILL", skillVar)
            .property("slot", skillNumber)
            .generate();

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
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        String category = ctx.IDENT().getText();

        cypherGenerator.addStatement(
            "SET " + skillVar + ".category = '" + category + "'"
        );

        return null;
    }

    @Override
    public Void visitSkillSinStmt(LPDLParser.SkillSinStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        String sin = ctx.sinAffinityType().getText();

        cypherGenerator.addStatement(
            "SET " + skillVar + ".sin = '" + sin + "'"
        );

        // SinAffinity 노드와 연결 (MERGE 사용)
        String sinVar = generateVariable("sin");
        cypherGenerator.mergeNode("SinAffinity", sinVar)
            .matchProperty("type", sin)
            .onCreate("name", getSinName(sin))
            .generate();

        cypherGenerator.createRelationship(skillVar, "USES_SIN", sinVar)
            .generate();

        return null;
    }

    @Override
    public Void visitAttackStmt(LPDLParser.AttackStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        String attackType = ctx.IDENT().getText();

        cypherGenerator.addStatement(
            "SET " + skillVar + ".attack_type = '" + attackType + "'"
        );

        return null;
    }

    @Override
    public Void visitDefenseStmt(LPDLParser.DefenseStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        String defenseType = ctx.IDENT().getText();

        cypherGenerator.addStatement(
            "SET " + skillVar + ".defense_type = '" + defenseType + "'"
        );

        return null;
    }

    @Override
    public Void visitQuantityStmt(LPDLParser.QuantityStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        int quantity = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + skillVar + ".quantity = " + quantity
        );

        return null;
    }

    @Override
    public Void visitKeywordStmt(LPDLParser.KeywordStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        String keyword = ctx.IDENT().getText();

        cypherGenerator.addStatement(
            "SET " + skillVar + ".keyword = '" + keyword + "'"
        );

        // StatusEffect 노드와 연결
        String statusVar = generateVariable("status");
        cypherGenerator.mergeNode("StatusEffect", statusVar)
            .matchProperty("type", keyword)
            .onCreate("name", getStatusEffectName(keyword))
            .generate();

        cypherGenerator.createRelationship(skillVar, "HAS_KEYWORD", statusVar)
            .generate();

        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // PASSIVE
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitPassiveDecl(LPDLParser.PassiveDeclContext ctx) {
        long personaId = context.getCurrentPersonaId();
        String personaVar = variableMap.get("persona_" + personaId);

        // Passive 변수 생성
        String passiveVar = generateVariable("passive");
        long passiveId = variableCounter;
        variableMap.put("passive_" + passiveId, passiveVar);
        context.enterPassive(passiveId);

        // Passive 타입과 이름
        String passiveKind = ctx.IDENT().getText();  // NORMAL, SUPPORT
        String passiveName = ctx.stringLiteral() != null ?
                            extractString(ctx.stringLiteral()) : "Passive";

        // Passive 노드 생성
        cypherGenerator.createNode("Passive", passiveVar)
            .property("name", passiveName)
            .property("kind", passiveKind)
            .generate();

        // Persona-[HAS_PASSIVE]->Passive 관계 생성
        cypherGenerator.createRelationship(personaVar, "HAS_PASSIVE", passiveVar)
            .generate();

        // passive body에 trigger/action이 있는지 확인
        boolean hasTriggerOrAction = false;
        if (ctx.passiveBody() != null) {
            for (var stmt : ctx.passiveBody().passiveStmt()) {
                if (stmt.triggerStmt() != null || stmt.actionSimple() != null) {
                    hasTriggerOrAction = true;
                    break;
                }
            }
        }

        // trigger/action이 있으면 implicit Effect 생성
        String effectVar = null;
        long effectId = 0;
        if (hasTriggerOrAction) {
            effectVar = generateVariable("eff");
            effectId = variableCounter;
            variableMap.put("effect_" + effectId, effectVar);

            cypherGenerator.createNode("Effect", effectVar)
                .property("name", passiveName + " 효과")
                .generate();

            cypherGenerator.createRelationship(passiveVar, "HAS_EFFECT", effectVar)
                .generate();

            context.enterEffect(effectId);
        }

        // passive body 순회
        if (ctx.passiveBody() != null) {
            for (var stmt : ctx.passiveBody().passiveStmt()) {
                visit(stmt);
            }
        }

        // Effect context 종료
        if (hasTriggerOrAction) {
            context.exitEffect();
        }

        context.exitPassive();
        return null;
    }

    @Override
    public Void visitPassiveConditionStmt(LPDLParser.PassiveConditionStmtContext ctx) {
        if (!context.hasPassive()) return null;

        long passiveId = context.getCurrentPassiveId();
        String passiveVar = variableMap.get("passive_" + passiveId);

        String conditionType = ctx.IDENT().getText();  // HOLD, RESONATE
        String sin = ctx.sinAffinityType().getText();
        Integer count = ctx.COUNT() != null && ctx.INT() != null ?
                       Integer.parseInt(ctx.INT().getText()) : null;

        StringBuilder sb = new StringBuilder("SET ");
        sb.append(passiveVar).append(".condition_type = '").append(conditionType).append("'");
        sb.append(", ").append(passiveVar).append(".condition_sin = '").append(sin).append("'");
        if (count != null) {
            sb.append(", ").append(passiveVar).append(".condition_count = ").append(count);
        }

        cypherGenerator.addStatement(sb.toString());

        // SinAffinity 노드와 REQUIRES_SIN 관계 생성
        String sinVar = generateVariable("sin");
        cypherGenerator.mergeNode("SinAffinity", sinVar)
            .matchProperty("type", sin)
            .onCreate("name", getSinName(sin))
            .generate();

        cypherGenerator.createRelationship(passiveVar, "REQUIRES_SIN", sinVar)
            .property("condition", conditionType)
            .property("count", count != null ? count : 0)
            .generate();

        return null;
    }

    @Override
    public Void visitPassiveSyncLevelStmt(LPDLParser.PassiveSyncLevelStmtContext ctx) {
        if (!context.hasPassive()) return null;

        long passiveId = context.getCurrentPassiveId();
        String passiveVar = variableMap.get("passive_" + passiveId);
        String syncLevel = ctx.IDENT().getText();

        cypherGenerator.addStatement(
            "SET " + passiveVar + ".sync_level = '" + syncLevel + "'"
        );

        return null;
    }

    // ═══════════════════════════════════════════════════════════════
    // EFFECT (Skill/Coin/Passive 공통)
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitEffectDecl(LPDLParser.EffectDeclContext ctx) {
        // Effect가 속한 부모 찾기 (Skill, Coin, Passive)
        String parentVar = null;
        String parentType = null;

        if (context.hasCoin()) {
            long coinId = context.getCurrentCoinId();
            parentVar = variableMap.get("coin_" + coinId);
            parentType = "Coin";
        } else if (context.hasSync()) {
            // Sync 노드는 생성하지 않으므로, Skill을 부모로 사용
            long skillId = context.getCurrentSkillId();
            parentVar = variableMap.get("skill_" + skillId);
            parentType = "Skill";
        } else if (context.hasPassive()) {
            long passiveId = context.getCurrentPassiveId();
            parentVar = variableMap.get("passive_" + passiveId);
            parentType = "Passive";
        }

        if (parentVar == null) {
            return null; // 부모를 찾을 수 없으면 스킵
        }

        // Effect 변수 생성
        String effectVar = generateVariable("eff");
        long effectId = variableCounter;
        variableMap.put("effect_" + effectId, effectVar);
        context.enterEffect(effectId);

        // Effect 이름
        String effectName = ctx.effectHeader() != null ?
                          extractEffectHeader(ctx.effectHeader()) : "Effect";

        // Effect 노드 생성
        cypherGenerator.createNode("Effect", effectVar)
            .property("name", effectName)
            .generate();

        // 부모-[HAS_EFFECT]->Effect 관계
        cypherGenerator.createRelationship(parentVar, "HAS_EFFECT", effectVar)
            .generate();

        // effect body 순회
        if (ctx.effectBody() != null) {
            for (var stmt : ctx.effectBody().effectStmt()) {
                visit(stmt);
            }
        }

        context.exitEffect();
        return null;
    }

    @Override
    public Void visitTriggerStmt(LPDLParser.TriggerStmtContext ctx) {
        if (!context.hasEffect()) return null;

        long effectId = context.getCurrentEffectId();
        String effectVar = variableMap.get("effect_" + effectId);
        String triggerType = ctx.IDENT().getText();

        // Effect에 trigger 프로퍼티 추가
        cypherGenerator.addStatement(
            "SET " + effectVar + ".trigger = '" + triggerType + "'"
        );

        // Trigger 노드 생성 (MERGE)
        String triggerVar = generateVariable("trig");
        cypherGenerator.mergeNode("Trigger", triggerVar)
            .matchProperty("type", triggerType)
            .onCreate("name", getTriggerName(triggerType))
            .generate();

        // Effect-[TRIGGERS_ON]->Trigger 관계
        cypherGenerator.createRelationship(effectVar, "TRIGGERS_ON", triggerVar)
            .generate();

        return null;
    }

    @Override
    public Void visitActionSimple(LPDLParser.ActionSimpleContext ctx) {
        if (!context.hasEffect()) return null;

        long effectId = context.getCurrentEffectId();
        String effectVar = variableMap.get("effect_" + effectId);

        // Action 타입 파악
        if (ctx.APPLY() != null) {
            handleApplyAction(effectVar, ctx);
        } else if (ctx.REMOVE() != null) {
            handleRemoveAction(effectVar, ctx);
        } else if (ctx.MODIFY() != null) {
            handleModifyAction(effectVar, ctx);
        }

        return null;
    }

    /**
     * APPLY 액션 처리
     */
    private void handleApplyAction(String effectVar, LPDLParser.ActionSimpleContext ctx) {
        // Target 추출
        String targetType = ctx.targetSpec() != null ?
                          ctx.targetSpec().getText().toUpperCase() : "TARGET";

        // Stat 추출
        String statType = ctx.statSpec().IDENT().getText();

        // Value 추출
        String value = ctx.additiveExpr() != null ?
                      ctx.additiveExpr().getText() : "0";

        // Action 노드 생성
        String actionVar = generateVariable("act");
        cypherGenerator.createNode("Action", actionVar)
            .property("type", "APPLY")
            .property("target", targetType)
            .property("stat", statType)
            .property("value", value)
            .generate();

        // Effect-[PERFORMS]->Action 관계
        cypherGenerator.createRelationship(effectVar, "PERFORMS", actionVar)
            .generate();

        // StatusEffect 노드와 연결 (BLEED, RUPTURE 등)
        if (isStatusEffect(statType)) {
            String statusVar = generateVariable("status");
            cypherGenerator.mergeNode("StatusEffect", statusVar)
                .matchProperty("type", statType)
                .onCreate("name", getStatusEffectName(statType))
                .generate();

            cypherGenerator.createRelationship(actionVar, "APPLIES", statusVar)
                .generate();
        }

        // nextTurn 옵션 처리
        for (var option : ctx.actionOptions()) {
            if (option.NEXTTURN() != null) {
                boolean nextTurn = option.booleanLiteral().TRUE() != null;
                cypherGenerator.addStatement(
                    "SET " + actionVar + ".next_turn = " + nextTurn
                );
            }
        }
    }

    /**
     * REMOVE 액션 처리
     */
    private void handleRemoveAction(String effectVar, LPDLParser.ActionSimpleContext ctx) {
        String targetType = ctx.targetSpec() != null ?
                          ctx.targetSpec().getText().toUpperCase() : "TARGET";
        String statType = ctx.statSpec().IDENT().getText();

        String actionVar = generateVariable("act");
        cypherGenerator.createNode("Action", actionVar)
            .property("type", "REMOVE")
            .property("target", targetType)
            .property("stat", statType)
            .generate();

        cypherGenerator.createRelationship(effectVar, "PERFORMS", actionVar)
            .generate();
    }

    /**
     * MODIFY 액션 처리
     */
    private void handleModifyAction(String effectVar, LPDLParser.ActionSimpleContext ctx) {
        String modifyTarget = ctx.POWER() != null ? "POWER" :
                            ctx.DAMAGE() != null ? "DAMAGE" : "UNKNOWN";

        String value = ctx.additiveExpr() != null ?
                      ctx.additiveExpr().getText() : "0";

        String actionVar = generateVariable("act");
        cypherGenerator.createNode("Action", actionVar)
            .property("type", "MODIFY")
            .property("modify_target", modifyTarget)
            .property("value", value)
            .generate();

        cypherGenerator.createRelationship(effectVar, "PERFORMS", actionVar)
            .generate();

        // coins 옵션 처리
        for (var option : ctx.actionOptions()) {
            if (option.COINS() != null) {
                String coinSelector = option.coinSelectorType().IDENT().getText();
                cypherGenerator.addStatement(
                    "SET " + actionVar + ".coin_selector = '" + coinSelector + "'"
                );
            }
        }
    }

    /**
     * StatusEffect인지 확인
     */
    private boolean isStatusEffect(String statType) {
        return statType.equals("BLEED") || statType.equals("BURN") ||
               statType.equals("TREMOR") || statType.equals("RUPTURE") ||
               statType.equals("SINKING") || statType.equals("PARALYSIS") ||
               statType.equals("VULNERABLE") || statType.equals("PIERCE_VULNERABLE") ||
               statType.equals("SLASH_VULNERABLE") || statType.equals("BLUNT_VULNERABLE");
    }

    // ═══════════════════════════════════════════════════════════════
    // COIN (Sync 내부)
    // ═══════════════════════════════════════════════════════════════

    @Override
    public Void visitSyncDecl(LPDLParser.SyncDeclContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);

        // Sync 변수 생성 (Effect나 Coin이 Sync에 속하는지 추적용)
        String syncVar = generateVariable("sync");
        long syncId = variableCounter;
        variableMap.put("sync_" + syncId, syncVar);
        context.enterSync(syncId);

        // Sync 레벨
        String syncLevel = extractSyncLevel(ctx.syncLevel());

        // Sync에 대한 노드는 생성하지 않고, Skill에 프로퍼티로 추가
        cypherGenerator.addStatement(
            "SET " + skillVar + ".sync_level = '" + syncLevel + "'"
        );

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
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        int basePower = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + skillVar + ".base_power = " + basePower
        );

        return null;
    }

    @Override
    public Void visitCoinPowerStmt(LPDLParser.CoinPowerStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        int coinPower = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + skillVar + ".coin_power = " + coinPower
        );

        return null;
    }

    @Override
    public Void visitCoinCountStmt(LPDLParser.CoinCountStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        int coinCount = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + skillVar + ".coin_count = " + coinCount
        );

        return null;
    }

    @Override
    public Void visitWeightStmt(LPDLParser.WeightStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        int weight = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + skillVar + ".weight = " + weight
        );

        return null;
    }

    @Override
    public Void visitLevelStmt(LPDLParser.LevelStmtContext ctx) {
        if (!context.hasSkill()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);
        int level = Integer.parseInt(ctx.INT().getText());

        cypherGenerator.addStatement(
            "SET " + skillVar + ".level = " + level
        );

        return null;
    }

    @Override
    public Void visitCoinDecl(LPDLParser.CoinDeclContext ctx) {
        if (!context.hasSync()) return null;

        long skillId = context.getCurrentSkillId();
        String skillVar = variableMap.get("skill_" + skillId);

        // Coin 변수 생성
        String coinVar = generateVariable("coin");
        long coinId = variableCounter;
        variableMap.put("coin_" + coinId, coinVar);
        context.enterCoin(coinId);

        // Coin 번호와 타입
        int coinNumber = Integer.parseInt(ctx.INT().getText());
        String coinType = ctx.IDENT().getText(); // NORMAL, UNBREAKABLE, REUSE

        // Coin 노드 생성
        cypherGenerator.createNode("Coin", coinVar)
            .property("number", coinNumber)
            .property("type", coinType)
            .generate();

        // Skill-[HAS_COIN]->Coin 관계
        cypherGenerator.createRelationship(skillVar, "HAS_COIN", coinVar)
            .property("order", coinNumber)
            .generate();

        // coin body 순회 (text는 스킵, effectInlineDecl만 처리)
        if (ctx.coinBody() != null) {
            if (ctx.coinBody().textDecl() != null) {
                // text 저장
                String text = extractTripleString(ctx.coinBody().textDecl().tripleStringLiteral());
                cypherGenerator.addStatement(
                    "SET " + coinVar + ".description = '" + text.replace("'", "\\'") + "'"
                );
            }

            for (var effectDecl : ctx.coinBody().effectInlineDecl()) {
                visitEffectInlineDecl(effectDecl);
            }
        }

        context.exitCoin();
        return null;
    }

    @Override
    public Void visitEffectInlineDecl(LPDLParser.EffectInlineDeclContext ctx) {
        // Effect가 속한 부모 찾기 (Coin)
        String parentVar = null;

        if (context.hasCoin()) {
            long coinId = context.getCurrentCoinId();
            parentVar = variableMap.get("coin_" + coinId);
        }

        if (parentVar == null) {
            return null;
        }

        // Effect 변수 생성
        String effectVar = generateVariable("eff");
        long effectId = variableCounter;
        variableMap.put("effect_" + effectId, effectVar);
        context.enterEffect(effectId);

        // Effect 이름
        String effectName = ctx.effectInlineHeader() != null ?
                          extractInlineEffectHeader(ctx.effectInlineHeader()) : "Effect";

        // Effect 노드 생성
        cypherGenerator.createNode("Effect", effectVar)
            .property("name", effectName)
            .generate();

        // 부모-[HAS_EFFECT]->Effect 관계
        cypherGenerator.createRelationship(parentVar, "HAS_EFFECT", effectVar)
            .generate();

        // effect body 순회
        if (ctx.effectBody() != null) {
            for (var stmt : ctx.effectBody().effectStmt()) {
                visit(stmt);
            }
        }

        context.exitEffect();
        return null;
    }

    /**
     * Inline Effect 헤더 추출
     */
    private String extractInlineEffectHeader(LPDLParser.EffectInlineHeaderContext ctx) {
        if (ctx.stringLiteral() != null) {
            return extractString(ctx.stringLiteral());
        }
        return "Effect";
    }

    // ═══════════════════════════════════════════════════════════════
    // HELPER METHODS
    // ═══════════════════════════════════════════════════════════════

    /**
     * Effect 헤더 추출
     */
    private String extractEffectHeader(LPDLParser.EffectHeaderContext ctx) {
        if (ctx.stringLiteral() != null) {
            return extractString(ctx.stringLiteral());
        } else if (ctx.STRING() != null) {
            String raw = ctx.STRING().getText();
            if (raw.length() >= 2 && raw.startsWith("\"") && raw.endsWith("\"")) {
                return raw.substring(1, raw.length() - 1);
            }
            return raw;
        }
        return "Effect";
    }

    /**
     * Sync 레벨 추출
     */
    private String extractSyncLevel(LPDLParser.SyncLevelContext ctx) {
        if (ctx.IDENT() != null) {
            return ctx.IDENT().getText();
        } else if (ctx.STRING() != null) {
            String raw = ctx.STRING().getText();
            if (raw.length() >= 2 && raw.startsWith("\"") && raw.endsWith("\"")) {
                return raw.substring(1, raw.length() - 1);
            }
            return raw;
        }
        return "SYNC_4";
    }

    /**
     * Triple string 추출
     */
    private String extractTripleString(LPDLParser.TripleStringLiteralContext ctx) {
        if (ctx == null || ctx.TRIPLE_STRING() == null) {
            return "";
        }
        String raw = ctx.TRIPLE_STRING().getText();
        // 앞뒤 """ 제거
        if (raw.startsWith("\"\"\"") && raw.endsWith("\"\"\"")) {
            return raw.substring(3, raw.length() - 3).trim();
        }
        return raw;
    }

    /**
     * Trigger 타입에 대한 한글 이름 반환
     */
    private String getTriggerName(String triggerType) {
        return switch (triggerType) {
            case "ON_HIT" -> "적중시";
            case "ON_HEAD_HIT" -> "앞면 적중시";
            case "ON_CRITICAL_HIT" -> "크리티컬 적중시";
            case "ON_WIN_CLASH" -> "합 승리시";
            case "ON_LOSE_CLASH" -> "합 패배시";
            case "ON_CLASH" -> "합 진행시";
            case "ON_USE" -> "사용시";
            case "ON_TURN_START" -> "턴 시작시";
            case "ON_TURN_END" -> "턴 종료시";
            case "ON_BATTLE_START" -> "전투 시작시";
            default -> triggerType;
        };
    }

    // ═══════════════════════════════════════════════════════════════
    // HELPER METHODS (기존)
    // ═══════════════════════════════════════════════════════════════

    /**
     * 죄악 타입에 대한 한글 이름 반환
     */
    private String getSinName(String sinType) {
        return switch (sinType) {
            case "WRATH" -> "분노";
            case "LUST" -> "색욕";
            case "SLOTH" -> "나태";
            case "GLUTTONY", "GREED" -> "탐식";
            case "GLOOM" -> "우울";
            case "PRIDE" -> "오만";
            case "ENVY" -> "질투";
            default -> sinType;
        };
    }

    /**
     * 상태이상 타입에 대한 한글 이름 반환
     */
    private String getStatusEffectName(String statusType) {
        return switch (statusType) {
            case "BLEED" -> "출혈";
            case "BURN" -> "화상";
            case "TREMOR" -> "진동";
            case "RUPTURE" -> "파열";
            case "SINKING" -> "침잠";
            case "CHARGE" -> "충전";
            case "POISE" -> "흔들림";
            default -> statusType;
        };
    }
}
