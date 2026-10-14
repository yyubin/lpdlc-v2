package org.yyubin.lpdl.exporter.cypher;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Cypher MERGE 노드 빌더 (중복 방지)
 *
 * 사용 예:
 * mergeNode("SinAffinity", "s")
 *   .matchProperty("type", "WRATH")  // MERGE 조건
 *   .onCreate("description", "분노")   // 생성 시에만 설정
 *   .generate()
 *
 * 생성 결과:
 * MERGE (s:SinAffinity {type: 'WRATH'})
 * ON CREATE SET s.description = '분노'
 */
public class MergeNodeBuilder {
    private final String label;
    private final String variable;
    private final CypherQueryGenerator generator;
    private final Map<String, Object> matchProperties;
    private final Map<String, Object> onCreateProperties;
    private final Map<String, Object> onMatchProperties;

    public MergeNodeBuilder(String label, String variable, CypherQueryGenerator generator) {
        this.label = label;
        this.variable = variable;
        this.generator = generator;
        this.matchProperties = new LinkedHashMap<>();
        this.onCreateProperties = new LinkedHashMap<>();
        this.onMatchProperties = new LinkedHashMap<>();
    }

    /**
     * MERGE 매칭 조건 프로퍼티
     */
    public MergeNodeBuilder matchProperty(String key, Object value) {
        matchProperties.put(key, value);
        return this;
    }

    /**
     * ON CREATE SET 프로퍼티 (노드 생성 시에만)
     */
    public MergeNodeBuilder onCreate(String key, Object value) {
        onCreateProperties.put(key, value);
        return this;
    }

    /**
     * ON MATCH SET 프로퍼티 (노드 매칭 시에만)
     */
    public MergeNodeBuilder onMatch(String key, Object value) {
        onMatchProperties.put(key, value);
        return this;
    }

    /**
     * Cypher 쿼리 생성 및 추가
     */
    public void generate() {
        StringBuilder sb = new StringBuilder();

        // MERGE 부분
        sb.append("MERGE (").append(variable).append(":").append(label);

        if (!matchProperties.isEmpty()) {
            sb.append(" {");
            String propsStr = matchProperties.entrySet().stream()
                .map(e -> formatProperty(e.getKey(), e.getValue()))
                .collect(Collectors.joining(", "));
            sb.append(propsStr);
            sb.append("}");
        }

        sb.append(")");

        // ON CREATE SET
        if (!onCreateProperties.isEmpty()) {
            sb.append("\nON CREATE SET ");
            String setStr = onCreateProperties.entrySet().stream()
                .map(e -> variable + "." + e.getKey() + " = " + formatValue(e.getValue()))
                .collect(Collectors.joining(", "));
            sb.append(setStr);
        }

        // ON MATCH SET
        if (!onMatchProperties.isEmpty()) {
            sb.append("\nON MATCH SET ");
            String setStr = onMatchProperties.entrySet().stream()
                .map(e -> variable + "." + e.getKey() + " = " + formatValue(e.getValue()))
                .collect(Collectors.joining(", "));
            sb.append(setStr);
        }

        generator.addStatement(sb.toString());
    }

    /**
     * 프로퍼티를 Cypher 형식으로 포맷팅 (MERGE 조건용)
     */
    private String formatProperty(String key, Object value) {
        return key + ": " + formatValue(value);
    }

    /**
     * 값을 Cypher 형식으로 포맷팅
     */
    private String formatValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            String escaped = ((String) value).replace("'", "\\'");
            return "'" + escaped + "'";
        } else if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else {
            String escaped = value.toString().replace("'", "\\'");
            return "'" + escaped + "'";
        }
    }
}
