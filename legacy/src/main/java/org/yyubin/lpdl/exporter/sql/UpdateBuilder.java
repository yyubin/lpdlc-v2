package org.yyubin.lpdl.exporter.sql;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UPDATE 문 빌더
 */
public class UpdateBuilder {
    private final String table;
    private final SQLGenerator generator;
    private final Map<String, Object> sets;
    private String whereClause;

    public UpdateBuilder(String table, SQLGenerator generator) {
        this.table = table;
        this.generator = generator;
        this.sets = new LinkedHashMap<>();
    }

    /**
     * SET 절 추가
     */
    public UpdateBuilder set(String column, Object value) {
        sets.put(column, value);
        return this;
    }

    /**
     * WHERE 절 설정
     */
    public UpdateBuilder where(String condition) {
        this.whereClause = condition;
        return this;
    }

    /**
     * WHERE 절 설정 (컬럼 = 값 형식)
     */
    public UpdateBuilder where(String column, Object value) {
        this.whereClause = column + " = " + formatValue(value);
        return this;
    }

    /**
     * UPDATE 문 생성 및 등록
     */
    public void generate() {
        if (sets.isEmpty()) {
            throw new IllegalStateException("No SET clauses specified for UPDATE statement");
        }

        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ").append(table).append(" SET ");

        // SET 절
        String setClause = sets.entrySet().stream()
            .map(e -> e.getKey() + " = " + formatValue(e.getValue()))
            .collect(Collectors.joining(", "));
        sql.append(setClause);

        // WHERE 절
        if (whereClause != null && !whereClause.isEmpty()) {
            sql.append(" WHERE ").append(whereClause);
        }

        generator.addStatement(sql.toString());
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

        return "'" + escapeSingleQuotes(value.toString()) + "'";
    }

    private String escapeSingleQuotes(String str) {
        return str.replace("'", "''");
    }
}
