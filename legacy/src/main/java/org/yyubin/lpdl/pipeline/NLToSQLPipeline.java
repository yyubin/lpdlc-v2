package org.yyubin.lpdl.pipeline;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.yyubin.lpdl.exporter.RDBExporter;
import org.yyubin.lpdl.llm.LLMClient;
import org.yyubin.lpdl.parser.LPDLLexer;
import org.yyubin.lpdl.parser.LPDLParser;

import java.io.PrintStream;

public class NLToSQLPipeline {

    private final LLMClient llmClient;
    private final int maxRetries;
    private final boolean verbose;
    private final PrintStream out;

    public NLToSQLPipeline(LLMClient llmClient, int maxRetries, boolean verbose, PrintStream out) {
        this.llmClient = llmClient;
        this.maxRetries = maxRetries;
        this.verbose = verbose;
        this.out = out;
    }

    public static class PipelineResult {
        private final String lpdl;
        private final String sql;
        private final int attempts;
        private final boolean success;
        private final String errorMessage;

        public PipelineResult(String lpdl, String sql, int attempts) {
            this.lpdl = lpdl;
            this.sql = sql;
            this.attempts = attempts;
            this.success = true;
            this.errorMessage = null;
        }

        public PipelineResult(String errorMessage, int attempts) {
            this.lpdl = null;
            this.sql = null;
            this.attempts = attempts;
            this.success = false;
            this.errorMessage = errorMessage;
        }

        public String getLpdl() { return lpdl; }
        public String getSql() { return sql; }
        public int getAttempts() { return attempts; }
        public boolean isSuccess() { return success; }
        public String getErrorMessage() { return errorMessage; }
    }

    public PipelineResult execute(String naturalLanguage) {
        log("[1/3] LLM으로 LPDL 생성 중...");

        String lpdl = null;
        String lastError = null;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                // Step 1: LLM으로 LPDL 생성
                if (attempt == 1) {
                    lpdl = llmClient.generateLPDL(naturalLanguage);
                } else {
                    log(String.format("\n재시도 중 (%d/%d)...", attempt, maxRetries));
                    log("[1/3] LLM으로 LPDL 생성 중 (피드백 포함)...");
                    lpdl = llmClient.regenerateLPDL(naturalLanguage, lpdl, lastError);
                }

                verboseLog("\n생성된 LPDL:\n" + lpdl + "\n");

                // Step 2: LPDL 검증 (파싱)
                log("[2/3] LPDL 검증 중...");
                validateLPDL(lpdl);
                log("✓ 검증 통과");

                // Step 3: SQL 변환
                log("[3/3] SQL 변환 중...");
                String sql = convertToSQL(lpdl);

                log("✓ 성공!\n");
                return new PipelineResult(lpdl, sql, attempt);

            } catch (LLMClient.LLMException e) {
                lastError = "LLM API 오류: " + e.getMessage();
                verboseLog("오류: " + lastError);

                if (attempt == maxRetries) {
                    return new PipelineResult(lastError, attempt);
                }

            } catch (LPDLValidationException e) {
                lastError = "LPDL 구문 오류: " + e.getMessage();
                log("✗ 구문 오류 발견: " + e.getMessage());

                if (attempt == maxRetries) {
                    return new PipelineResult(lastError, attempt);
                }

            } catch (Exception e) {
                lastError = "예상치 못한 오류: " + e.getMessage();
                verboseLog("오류: " + lastError);

                if (attempt == maxRetries) {
                    return new PipelineResult(lastError, attempt);
                }
            }
        }

        return new PipelineResult(lastError != null ? lastError : "알 수 없는 오류", maxRetries);
    }

    private void validateLPDL(String lpdlCode) throws LPDLValidationException {
        try {
            CharStream input = CharStreams.fromString(lpdlCode);
            LPDLLexer lexer = new LPDLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LPDLParser parser = new LPDLParser(tokens);

            // 에러 리스너 추가
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line,
                                        int charPositionInLine,
                                        String msg,
                                        RecognitionException e) {
                    // RuntimeException으로 래핑하여 throw
                    throw new LPDLValidationRuntimeException(
                        String.format("line %d:%d - %s", line, charPositionInLine, msg)
                    );
                }
            });

            // 파싱 시도
            parser.program();

        } catch (LPDLValidationRuntimeException e) {
            throw new LPDLValidationException(e.getMessage());
        } catch (Exception e) {
            throw new LPDLValidationException("파싱 실패: " + e.getMessage());
        }
    }

    private String convertToSQL(String lpdlCode) throws Exception {
        CharStream input = CharStreams.fromString(lpdlCode);
        LPDLLexer lexer = new LPDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LPDLParser parser = new LPDLParser(tokens);
        LPDLParser.ProgramContext programCtx = parser.program();

        RDBExporter exporter = new RDBExporter();
        return exporter.export(programCtx);
    }

    private void log(String message) {
        out.println(message);
    }

    private void verboseLog(String message) {
        if (verbose) {
            out.println(message);
        }
    }

    public static class LPDLValidationException extends Exception {
        public LPDLValidationException(String message) {
            super(message);
        }
    }

    private static class LPDLValidationRuntimeException extends RuntimeException {
        public LPDLValidationRuntimeException(String message) {
            super(message);
        }
    }
}
