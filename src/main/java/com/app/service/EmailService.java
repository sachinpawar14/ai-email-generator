package com.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public EmailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateEmail(String purpose, String name, String tone) {

        String url =
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                        + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String prompt = "Write a short " + tone +
                " email to " + name +
                " about " + purpose +
                ". Keep it under 80 words.";

        Map<String, Object> textMap = new HashMap<>();
        textMap.put("text", prompt);

        Map<String, Object> partMap = new HashMap<>();
        partMap.put("parts", List.of(textMap));

        Map<String, Object> body = new HashMap<>();
        body.put("contents", List.of(partMap));

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, request, Map.class);

        Map candidate = (Map) ((List) response.getBody().get("candidates")).get(0);
        Map content = (Map) candidate.get("content");
        Map part = (Map) ((List) content.get("parts")).get(0);

        return part.get("text").toString();
    }
}
