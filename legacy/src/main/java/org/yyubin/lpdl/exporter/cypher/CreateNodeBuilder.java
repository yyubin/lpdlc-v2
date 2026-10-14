package org.yyubin.lpdl.exporter.cypher;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Cypher CREATE 노드 빌더
 *
 * 사용 예:
 * createNode("Persona", "p")
 *   .property("name", "홍루")
 *   .property("grade", 3)
 *   .generate()
 *
 * 생성 결과:
 * CREATE (p:Persona {name: '홍루', grade: 3})
 */
public class CreateNodeBuilder {
    private final String label;
    private final String variable;
    private final CypherQueryGenerator generator;
    private final Map<String, Object> properties;

    public CreateNodeBuilder(String label, String variable, CypherQueryGenerator generator) {
        this.label = label;
        this.variable = variable;
        this.generator = generator;
        this.properties = new LinkedHashMap<>();
    }

    /**
     * 프로퍼티 추가
     */
    public CreateNodeBuilder property(String key, Object value) {
        properties.put(key, value);
        return this;
    }

    /**
     * 여러 프로퍼티 한번에 추가
     */
    public CreateNodeBuilder properties(Map<String, Object> props) {
        properties.putAll(props);
        return this;
    }

    /**
     * Cypher 쿼리 생성 및 추가
     */
    public void generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE (").append(variable).append(":").append(label);

        if (!properties.isEmpty()) {
            sb.append(" {");
            String propsStr = properties.entrySet().stream()
                .map(e -> formatProperty(e.getKey(), e.getValue()))
                .collect(Collectors.joining(", "));
            sb.append(propsStr);
            sb.append("}");
        }

        sb.append(")");
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
            // 문자열은 작은따옴표로 감싸고, 내부 작은따옴표는 이스케이프
            String escaped = ((String) value).replace("'", "\\'");
            formattedValue = "'" + escaped + "'";
        } else if (value instanceof Number || value instanceof Boolean) {
            formattedValue = value.toString();
        } else {
            // 기타 타입은 toString()으로 변환 후 문자열 취급
            String escaped = value.toString().replace("'", "\\'");
            formattedValue = "'" + escaped + "'";
        }

        return key + ": " + formattedValue;
    }
}
