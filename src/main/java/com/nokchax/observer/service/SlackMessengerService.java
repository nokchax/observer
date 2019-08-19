package com.nokchax.observer.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.nokchax.observer.domain.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/*
    send msg using message api
 */
@Service
public class SlackMessengerService implements MessengerService {
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    @Value("${slack.api.message.chatUrl}")
    private String messageChatUrl;
    @Value("${slack.bot.token}")
    private String token;

    public SlackMessengerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean sendMessage(Message message) {
        ResponseEntity<JsonNode> response = restTemplate.exchange(
                messageChatUrl,
                HttpMethod.POST,
                createHttpEntity(message),
                JsonNode.class
        );

        return response.getBody().get("ok").asBoolean()
                && !response.getBody().has("error");
    }

    private HttpEntity<Message> createHttpEntity(Message message) {
        return new HttpEntity<>(message, headers);
    }

    @PostConstruct
    private void init() {
        headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }
}
