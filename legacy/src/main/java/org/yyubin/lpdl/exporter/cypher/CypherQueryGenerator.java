package org.yyubin.lpdl.exporter.cypher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Cypher 쿼리 생성 및 관리 클래스
 * Neo4j 그래프 DB를 위한 쿼리 생성
 */
public class CypherQueryGenerator {
    private final List<String> statements;

    public CypherQueryGenerator() {
        this.statements = new ArrayList<>();
    }

    /**
     * CREATE 노드 빌더 생성
     */
    public CreateNodeBuilder createNode(String label, String variable) {
        return new CreateNodeBuilder(label, variable, this);
    }

    /**
     * MERGE 노드 빌더 생성 (중복 방지)
     */
    public MergeNodeBuilder mergeNode(String label, String variable) {
        return new MergeNodeBuilder(label, variable, this);
    }

    /**
     * CREATE 관계 빌더 생성
     */
    public CreateRelationshipBuilder createRelationship(String fromVar, String relType, String toVar) {
        return new CreateRelationshipBuilder(fromVar, relType, toVar, this);
    }

    /**
     * Cypher 쿼리 직접 추가
     */
    public void addStatement(String cypher) {
        statements.add(cypher);
    }

    /**
     * 모든 Cypher 쿼리를 하나의 문자열로 반환
     */
    public String generateAll() {
        if (statements.isEmpty()) {
            return "";
        }
        return String.join("\n\n", statements);
    }

    /**
     * Cypher 파일로 저장
     */
    public void writeToFile(Path path) throws IOException {
        Files.writeString(path, generateAll());
    }

    /**
     * 생성된 쿼리 개수
     */
    public int getStatementCount() {
        return statements.size();
    }

    /**
     * 모든 쿼리 초기화
     */
    public void clear() {
        statements.clear();
    }

    /**
     * 생성된 모든 쿼리 리스트 반환 (테스트용)
     */
    public List<String> getStatements() {
        return new ArrayList<>(statements);
    }
}
