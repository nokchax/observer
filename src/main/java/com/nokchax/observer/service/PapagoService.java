package com.nokchax.observer.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PapagoService implements TranslateService {
    @Value("naver.oauth.clientId")
    private String clientId;
    @Value("naver.oauth.clientSecret")
    private String clientSecret;

    private RestTemplate restTemplate;

    public PapagoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String translate(String word) {
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
        header.add("X-Naver-Client-Id", clientId);
        header.add("X-Naver-Client-Secret", clientSecret);

        ResponseEntity<JsonNode> response = restTemplate.exchange(
                "https://openapi.naver.com/v1/papago/n2mt",
                HttpMethod.POST,
                new HttpEntity("source=ko&target=en&text=" + word, header),
                JsonNode.class
        );
        System.out.println(response.getBody().get("message").get("result").get("translatedText").asText());

        return response.getBody().get("message").get("result").get("translatedText").asText();
    }
}
