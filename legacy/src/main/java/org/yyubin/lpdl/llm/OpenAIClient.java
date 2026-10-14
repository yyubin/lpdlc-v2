package org.yyubin.lpdl.llm;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.yyubin.lpdl.prompt.PromptTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OpenAIClient implements LLMClient {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient httpClient;
    private final String apiKey;
    private final String model;
    private final Gson gson;
    private final PromptTemplate promptTemplate;

    public OpenAIClient(String apiKey, String model) {
        this.apiKey = apiKey;
        this.model = model != null ? model : "gpt-4o";
        this.gson = new Gson();
        this.promptTemplate = new PromptTemplate();

        this.httpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();
    }

    public OpenAIClient(String apiKey) {
        this(apiKey, null);
    }

    @Override
    public String generateLPDL(String naturalLanguage) throws LLMException {
        String systemPrompt = promptTemplate.getSystemPrompt();
        String userPrompt = promptTemplate.getUserPrompt(naturalLanguage);

        return callAPI(systemPrompt, userPrompt);
    }

    @Override
    public String regenerateLPDL(String naturalLanguage, String previousLPDL, String errorMessage) throws LLMException {
        String systemPrompt = promptTemplate.getSystemPrompt();
        String userPrompt = promptTemplate.getRegenerationPrompt(naturalLanguage, previousLPDL, errorMessage);

        return callAPI(systemPrompt, userPrompt);
    }

    private String callAPI(String systemPrompt, String userPrompt) throws LLMException {
        // 요청 JSON 생성
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("model", model);
        requestBody.addProperty("temperature", 0.1);
        requestBody.addProperty("max_tokens", 2000);

        JsonArray messages = new JsonArray();

        JsonObject systemMessage = new JsonObject();
        systemMessage.addProperty("role", "system");
        systemMessage.addProperty("content", systemPrompt);
        messages.add(systemMessage);

        JsonObject userMessage = new JsonObject();
        userMessage.addProperty("role", "user");
        userMessage.addProperty("content", userPrompt);
        messages.add(userMessage);

        requestBody.add("messages", messages);

        // HTTP 요청
        RequestBody body = RequestBody.create(gson.toJson(requestBody), JSON);
        Request request = new Request.Builder()
            .url(API_URL)
            .header("Authorization", "Bearer " + apiKey)
            .header("Content-Type", "application/json")
            .post(body)
            .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errorBody = response.body() != null ? response.body().string() : "No error body";
                throw new LLMException("OpenAI API 호출 실패: " + response.code() + " - " + errorBody);
            }

            String responseBody = response.body().string();
            JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);

            // 응답에서 생성된 텍스트 추출
            String generatedText = jsonResponse
                .getAsJsonArray("choices")
                .get(0).getAsJsonObject()
                .getAsJsonObject("message")
                .get("content").getAsString();

            // 마크다운 코드 블록 제거 및 정리
            return cleanLPDLCode(generatedText);

        } catch (IOException e) {
            throw new LLMException("OpenAI API 통신 오류", e);
        } catch (Exception e) {
            throw new LLMException("응답 파싱 오류: " + e.getMessage(), e);
        }
    }


    private String cleanLPDLCode(String text) {
        // 마크다운 코드 블록 제거
        text = text.replaceAll("```lpdl\\s*", "");
        text = text.replaceAll("```\\s*", "");

        // 앞뒤 공백 제거
        text = text.trim();

        return text;
    }
}
