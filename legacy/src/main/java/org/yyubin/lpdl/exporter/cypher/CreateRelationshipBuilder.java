package org.yyubin.lpdl.exporter.cypher;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Cypher CREATE 관계 빌더
 *
 * 사용 예:
 * createRelationship("p", "HAS_SKILL", "s")
 *   .property("slot", 1)
 *   .property("level", 40)
 *   .generate()
 *
 * 생성 결과:
 * CREATE (p)-[:HAS_SKILL {slot: 1, level: 40}]->(s)
 */
public class CreateRelationshipBuilder {
    private final String fromVariable;
    private final String relationshipType;
    private final String toVariable;
    private final CypherQueryGenerator generator;
    private final Map<String, Object> properties;

    public CreateRelationshipBuilder(
            String fromVariable,
            String relationshipType,
            String toVariable,
            CypherQueryGenerator generator) {
        this.fromVariable = fromVariable;
        this.relationshipType = relationshipType;
        this.toVariable = toVariable;
        this.generator = generator;
        this.properties = new LinkedHashMap<>();
    }

    /**
     * 관계 프로퍼티 추가
     */
    public CreateRelationshipBuilder property(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    /**
     * 여러 프로퍼티 한번에 추가
     */
    public CreateRelationshipBuilder properties(Map<String, Object> props) {
        properties.putAll(props);
        return this;
    }

    /**
     * Cypher 쿼리 생성 및 추가
     */
    public void generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE (").append(fromVariable).append(")-[:");
        sb.append(relationshipType);

        if (!properties.isEmpty()) {
            sb.append(" {");
            String propsStr = properties.entrySet().stream()
                .map(e -> formatProperty(e.getKey(), e.getValue()))
                .collect(Collectors.joining(", "));
            sb.append(propsStr);
            sb.append("}");
        }

        sb.append("]->(").append(toVariable).append(")");
        generator.addStatement(sb.toString());
    }

    /**
     * 프로퍼티를 Cypher 형식으로 포맷팅
     */
    private String formatProperty(String key, Object value) {
        String formattedValue;

        if (value == null) {
            formattedValue = "null";
        } else if (value instanceof String) {
            String escaped = ((String) value).replace("'", "\\'");
            formattedValue = "'" + escaped + "'";
        } else if (value instanceof Number || value instanceof Boolean) {
            formattedValue = value.toString();
        } else {
            String escaped = value.toString().replace("'", "\\'");
            formattedValue = "'" + escaped + "'";
        }

        return key + ": " + formattedValue;
    }
}
