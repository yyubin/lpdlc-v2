package org.yyubin.lpdl.llm;

public interface LLMClient {

    String generateLPDL(String naturalLanguage) throws LLMException;

    String regenerateLPDL(String naturalLanguage, String previousLPDL, String errorMessage) throws LLMException;

    class LLMException extends Exception {
        public LLMException(String message) {
            super(message);
        }

        public LLMException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
