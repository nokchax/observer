package com.nokchax.observer.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.nokchax.observer.domain.PapagoRequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class PapagoService implements TranslateService {
    @Value("${naver.oauth.clientId}")
    private String clientId;
    @Value("${naver.oauth.clientSecret}")
    private String clientSecret;

    private HttpHeaders headers;

    private RestTemplate restTemplate;

    public PapagoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String translate(String word) {
        ResponseEntity<JsonNode> response = restTemplate.exchange(
                "https://openapi.naver.com/v1/papago/n2mt",
                HttpMethod.POST,
                createHttpEntity(word),
                JsonNode.class
        );

        return response.getBody().get("message").get("result").get("translatedText").asText();
    }

    public HttpEntity createHttpEntity(String word) {
        return new HttpEntity(new PapagoRequestBody(word).toBody(), headers);
    }

    // content_type 이 아래와 같을 경우 body는 key=value&key2=value2&... 와 같이 들어가야 한다.
    @PostConstruct
    public void init() {
        headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.add("X-Naver-Client-Id", clientId);
        headers.add("X-Naver-Client-Secret", clientSecret);
    }
}
