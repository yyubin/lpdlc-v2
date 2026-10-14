package org.yyubin.lpdl.exporter.sql;

/**
 * SQL 변수 참조 (MySQL의 @variable)
 * AUTO_INCREMENT로 생성된 ID를 저장하고 FK로 참조할 때 사용
 */
public class SQLVariable {
    private final String name;

    public SQLVariable(String name) {
        this.name = name;
    }

    /**
     * MySQL 변수 형식으로 반환 (@variable_name)
     */
    public String toSQL() {
        return "@" + name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return toSQL();
    }
}