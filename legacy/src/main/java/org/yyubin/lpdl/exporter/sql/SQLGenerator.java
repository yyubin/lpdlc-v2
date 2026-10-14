package org.yyubin.lpdl.exporter.sql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL 문 생성 및 관리 클래스
 */
public class SQLGenerator {
    private final List<String> statements;

    public SQLGenerator() {
        this.statements = new ArrayList<>();
    }

    /**
     * INSERT 문 빌더 생성
     */
    public InsertBuilder insert(String table) {
        return new InsertBuilder(table, this);
    }

    /**
     * UPDATE 문 생성
     */
    public UpdateBuilder update(String table) {
        return new UpdateBuilder(table, this);
    }

    /**
     * SQL 문 직접 추가
     */
    public void addStatement(String sql) {
        statements.add(sql);
    }

    /**
     * 모든 SQL 문을 하나의 문자열로 반환
     */
    public String generateAll() {
        if (statements.isEmpty()) {
            return "";
        }
        return String.join(";\n", statements) + ";";
    }

    /**
     * SQL 파일로 저장
     */
    public void writeToFile(Path path) throws IOException {
        Files.writeString(path, generateAll());
    }

    /**
     * 생성된 SQL 문 개수
     */
    public int getStatementCount() {
        return statements.size();
    }

    /**
     * 모든 SQL 문 초기화
     */
    public void clear() {
        statements.clear();
    }

    /**
     * 생성된 모든 SQL 문 리스트 반환 (테스트용)
     */
    public List<String> getStatements() {
        return new ArrayList<>(statements);
    }
}
