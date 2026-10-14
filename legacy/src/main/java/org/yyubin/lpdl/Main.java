package org.yyubin.lpdl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.yyubin.lpdl.exporter.RDBExporter;
import org.yyubin.lpdl.exporter.Neo4jExporter;
import org.yyubin.lpdl.parser.LPDLLexer;
import org.yyubin.lpdl.parser.LPDLParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * LPDL 컴파일러 CLI
 *
 *   java -jar lpdl.jar <input.lpdl> [output.sql]
 *
 * Examples:
 *   java -jar lpdl.jar persona.lpdl            # SQL을 콘솔에 출력
 *   java -jar lpdl.jar persona.lpdl output.sql # SQL을 파일로 저장
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            System.exit(1);
        }

        String inputPath = args[0];
        String outputPath = args.length > 1 ? args[1] : null;

        try {
            String sql = compileLPDL(inputPath);
            String cypher = compileToNeo4j(inputPath);

            if (outputPath != null) {
                // SQL 파일로 저장
                Files.writeString(Paths.get(outputPath), sql);
                System.out.println("✓ SQL이 성공적으로 생성되었습니다: " + outputPath);

                // Cypher 파일도 저장
                String cypherPath = outputPath.replace(".sql", ".cypher");
                Files.writeString(Paths.get(cypherPath), cypher);
                System.out.println("✓ Cypher 쿼리가 성공적으로 생성되었습니다: " + cypherPath);
            } else {
                // 콘솔에 출력
                System.out.println("=== SQL ===");
                System.out.println(sql);
                System.out.println();
                System.out.println("=== Neo4j Cypher ===");
                System.out.println(cypher);
            }

        } catch (LPDLCompileException e) {
            System.err.println("컴파일 오류: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("파일 오류: " + e.getMessage());
            System.exit(1);
        }
    }

    private static String compileLPDL(String inputPath) throws IOException, LPDLCompileException {
        Path path = Paths.get(inputPath);

        if (!Files.exists(path)) {
            throw new LPDLCompileException("파일을 찾을 수 없습니다: " + inputPath);
        }

        if (!inputPath.endsWith(".lpdl")) {
            System.err.println("경고: 파일 확장자가 .lpdl이 아닙니다.");
        }

        // 파일 읽기
        String lpdlCode = Files.readString(path);

        // ANTLR 파싱
        CharStream input = CharStreams.fromString(lpdlCode);
        LPDLLexer lexer = new LPDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LPDLParser parser = new LPDLParser(tokens);

        // 파싱 에러 수집
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol,
                                    int line,
                                    int charPositionInLine,
                                    String msg,
                                    RecognitionException e) {
                throw new LPDLCompileException(
                    String.format("%s:%d:%d - %s", inputPath, line, charPositionInLine, msg)
                );
            }
        });

        // 파싱
        LPDLParser.ProgramContext programCtx = parser.program();

        // SQL 변환
        RDBExporter exporter = new RDBExporter();
        String sql = exporter.export(programCtx);

        return sql;
    }

    private static String compileToNeo4j(String inputPath) throws IOException, LPDLCompileException {
        Path path = Paths.get(inputPath);

        if (!Files.exists(path)) {
            throw new LPDLCompileException("파일을 찾을 수 없습니다: " + inputPath);
        }

        // 파일 읽기
        String lpdlCode = Files.readString(path);

        // ANTLR 파싱
        CharStream input = CharStreams.fromString(lpdlCode);
        LPDLLexer lexer = new LPDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LPDLParser parser = new LPDLParser(tokens);

        // 파싱 에러 수집
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol,
                                    int line,
                                    int charPositionInLine,
                                    String msg,
                                    RecognitionException e) {
                throw new LPDLCompileException(
                    String.format("%s:%d:%d - %s", inputPath, line, charPositionInLine, msg)
                );
            }
        });

        // 파싱
        LPDLParser.ProgramContext programCtx = parser.program();

        // Neo4j Cypher 변환
        Neo4jExporter exporter = new Neo4jExporter();
        String cypher = exporter.export(programCtx);

        return cypher;
    }

    private static void printUsage() {
        System.out.println("LPDL Compiler - LPDL을 MySQL SQL로 변환합니다");
        System.out.println();
        System.out.println("사용법:");
        System.out.println("  java -jar lpdl.jar <input.lpdl> [output.sql]");
        System.out.println();
        System.out.println("예제:");
        System.out.println("  java -jar lpdl.jar persona.lpdl            # SQL을 콘솔에 출력");
        System.out.println("  java -jar lpdl.jar persona.lpdl output.sql # SQL을 파일로 저장");
        System.out.println();
        System.out.println("또는 Gradle로 실행:");
        System.out.println("  ./gradlew run --args='<input.lpdl> [output.sql]'");
    }

    public static class LPDLCompileException extends RuntimeException {
        public LPDLCompileException(String message) {
            super(message);
        }
    }
}
