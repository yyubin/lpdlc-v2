package org.yyubin.lpdl;

import io.github.cdimascio.dotenv.Dotenv;
import org.yyubin.lpdl.llm.LLMClient;
import org.yyubin.lpdl.llm.OpenAIClient;
import org.yyubin.lpdl.pipeline.NLToSQLPipeline;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.Callable;

@Command(
    name = "nlcompile",
    description = "자연어를 LPDL을 거쳐 SQL로 변환합니다",
    mixinStandardHelpOptions = true,
    version = "1.0"
)
public class NaturalLanguageCompiler implements Callable<Integer> {

    @Parameters(
        index = "0",
        description = "자연어 설명 (또는 --input 사용)",
        arity = "0..1"
    )
    private String naturalLanguage;

    @Option(
        names = {"-i", "--input"},
        description = "입력 파일 (자연어 설명이 담긴 텍스트 파일)"
    )
    private String inputFile;

    @Option(
        names = {"-o", "--output"},
        description = "출력 파일 (SQL 저장, 생략 시 콘솔 출력)"
    )
    private String outputFile;

    @Option(
        names = {"--save-lpdl"},
        description = "중간 LPDL 코드를 파일로 저장"
    )
    private String lpdlOutputFile;

    @Option(
        names = {"-p", "--provider"},
        description = "LLM 제공자 (openai, claude, ollama)",
        defaultValue = "openai"
    )
    private String provider;

    @Option(
        names = {"-m", "--model"},
        description = "LLM 모델 (예: gpt-4, claude-3-5-sonnet-20241022)"
    )
    private String model;

    @Option(
        names = {"--max-retries"},
        description = "최대 재시도 횟수",
        defaultValue = "3"
    )
    private int maxRetries;

    @Option(
        names = {"-v", "--verbose"},
        description = "상세 로그 출력"
    )
    private boolean verbose;

    @Option(
        names = {"--dry-run"},
        description = "LPDL만 생성하고 SQL 변환은 하지 않음"
    )
    private boolean dryRun;

    @Option(
        names = {"--interactive"},
        description = "대화형 모드"
    )
    private boolean interactive;

    @Override
    public Integer call() throws Exception {
        // API 키 확인
        String apiKey = getApiKey();
        if (apiKey == null) {
            System.err.println("오류: API 키가 설정되지 않았습니다.");
            System.err.println("다음 중 하나를 선택하여 API 키를 설정해주세요:");
            System.err.println();
            System.err.println("1. .env 파일 사용 (권장):");
            System.err.println("   .env.example을 .env로 복사하고 API 키를 입력하세요");
            System.err.println("   cp .env.example .env");
            System.err.println();
            System.err.println("2. 환경 변수 사용:");
            System.err.println("   export OPENAI_API_KEY=your-key-here");
            return 1;
        }

        // 인터랙티브 모드
        if (interactive) {
            return runInteractiveMode(apiKey);
        }

        // 입력 가져오기
        String input = getInput();
        if (input == null) {
            System.err.println("오류: 자연어 입력을 제공해주세요.");
            System.err.println("사용법: nlcompile \"설명...\" 또는 nlcompile --input file.txt");
            return 1;
        }

        // LLM 클라이언트 생성
        LLMClient llmClient = createLLMClient(apiKey);

        // 파이프라인 실행
        NLToSQLPipeline pipeline = new NLToSQLPipeline(llmClient, maxRetries, verbose, System.out);
        NLToSQLPipeline.PipelineResult result = pipeline.execute(input);

        if (!result.isSuccess()) {
            System.err.println("\n컴파일 실패: " + result.getErrorMessage());
            System.err.println("시도 횟수: " + result.getAttempts());
            return 1;
        }

        // LPDL 저장
        if (lpdlOutputFile != null) {
            Files.writeString(Paths.get(lpdlOutputFile), result.getLpdl());
            System.out.println("✓ LPDL 저장: " + lpdlOutputFile);
        }

        // Dry-run 모드
        if (dryRun) {
            System.out.println("\n생성된 LPDL:");
            System.out.println(result.getLpdl());
            return 0;
        }

        // SQL 출력
        if (outputFile != null) {
            Files.writeString(Paths.get(outputFile), result.getSql());
            System.out.println("✓ SQL 저장: " + outputFile);
        } else {
            System.out.println("\n생성된 SQL:");
            System.out.println(result.getSql());
        }

        System.out.println("\n총 시도 횟수: " + result.getAttempts());
        return 0;
    }

    private int runInteractiveMode(String apiKey) {
        System.out.println("LPDL Natural Language Compiler (Interactive Mode)");
        System.out.println("명령어: exit (종료), help (도움말)");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        LLMClient llmClient = createLLMClient(apiKey);
        NLToSQLPipeline pipeline = new NLToSQLPipeline(llmClient, maxRetries, verbose, System.out);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("종료합니다.");
                break;
            }

            if (input.equalsIgnoreCase("help")) {
                printInteractiveHelp();
                continue;
            }

            // 파이프라인 실행
            NLToSQLPipeline.PipelineResult result = pipeline.execute(input);

            if (!result.isSuccess()) {
                System.err.println("✗ 실패: " + result.getErrorMessage());
            } else {
                System.out.println("\n생성된 SQL:");
                System.out.println(result.getSql());
            }

            System.out.println();
        }

        scanner.close();
        return 0;
    }

    /**
     * 입력 가져오기
     */
    private String getInput() throws IOException {
        if (inputFile != null) {
            return Files.readString(Paths.get(inputFile));
        }
        return naturalLanguage;
    }

    private String getApiKey() {
        String envVar = switch (provider.toLowerCase()) {
            case "openai" -> "OPENAI_API_KEY";
            default -> "OPENAI_API_KEY";
        };

        if (envVar == null) {
            return "not-required";
        }

        try {
            Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()  // .env 파일이 없어도 에러 안남
                .load();
            String key = dotenv.get(envVar);
            if (key != null && !key.isEmpty()) {
                return key;
            }
        } catch (Exception e) {

        }

        return System.getenv(envVar);
    }

    private LLMClient createLLMClient(String apiKey) {
        return switch (provider.toLowerCase()) {
            case "openai" -> new OpenAIClient(apiKey, model);
            default -> new OpenAIClient(apiKey, model);
        };
    }

    private void printInteractiveHelp() {
        System.out.println("사용 가능한 명령어:");
        System.out.println("  exit, quit  - 종료");
        System.out.println("  help        - 도움말 출력");
        System.out.println("  <자연어>    - LPDL 및 SQL 생성");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new NaturalLanguageCompiler()).execute(args);
        System.exit(exitCode);
    }
}
