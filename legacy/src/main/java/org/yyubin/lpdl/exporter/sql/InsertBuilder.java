package org.yyubin.lpdl.exporter.sql;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * INSERT 문 빌더
 */
public class InsertBuilder {
    private final String table;
    private final SQLGenerator generator;
    private final Map<String, Object> values;

    public InsertBuilder(String table, SQLGenerator generator) {
        this.table = table;
        this.generator = generator;
        this.values = new LinkedHashMap<>();
    }

    /**
     * 컬럼 값 추가
     */
    public InsertBuilder value(String column, Object value) {
        values.put(column, value);
        return this;
    }

    /**
     * INSERT 문 생성 및 등록 (일반)
     */
    public void generate() {
        generateInternal(null);
    }

    /**
     * INSERT 문 생성 및 AUTO_INCREMENT ID를 변수에 저장
     * MySQL의 LAST_INSERT_ID()를 사용하여 생성된 ID를 변수에 저장
     *
     * @param variableName 저장할 변수 이름 (예: "persona_1")
     * @return SQLVariable 객체 (FK 참조 시 사용)
     */
    public SQLVariable generateWithAutoId(String variableName) {
        generateInternal(variableName);
        return new SQLVariable(variableName);
    }

    /**
     * INSERT 문 생성 내부 로직
     */
    private void generateInternal(String autoIdVariable) {
        if (values.isEmpty()) {
            throw new IllegalStateException("No values specified for INSERT statement");
        }

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ").append(table).append(" (");

        // 컬럼 이름들
        sql.append(String.join(", ", values.keySet()));
        sql.append(") VALUES (");

        // 값들
        List<String> valueStrings = values.values().stream()
            .map(this::formatValue)
            .collect(Collectors.toList());
        sql.append(String.join(", ", valueStrings));
        sql.append(")");

        generator.addStatement(sql.toString());

        // AUTO_INCREMENT ID를 변수에 저장
        if (autoIdVariable != null) {
            generator.addStatement("SET @" + autoIdVariable + " = LAST_INSERT_ID()");
        }
    }

    /**
     * 값을 SQL 형식으로 포맷팅 (MySQL 호환)
     */
    private String formatValue(Object value) {
        if (value == null) {
            return "NULL";
        }
        if (value instanceof SQLVariable) {
            // MySQL 변수 참조 (@variable)
            return ((SQLVariable) value).toSQL();
        }
        if (value instanceof String) {
            return "'" + escapeSingleQuotes((String) value) + "'";
        }
        if (value instanceof Boolean) {
            // MySQL은 TRUE/FALSE보다 1/0을 선호
            return ((Boolean) value) ? "1" : "0";
        }
        if (value instanceof Enum) {
            return "'" + ((Enum<?>) value).name() + "'";
        }
        if (value instanceof Number) {
            return value.toString();
        }

        // 기타 타입은 toString() 사용
        return "'" + escapeSingleQuotes(value.toString()) + "'";
    }

    /**
     * 문자열 내 작은따옴표 이스케이프
     */
    private String escapeSingleQuotes(String str) {
        return str.replace("'", "''");
    }
}
