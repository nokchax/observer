package com.nokchax.observer.service;

import com.nokchax.observer.domain.PayLoad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackServiceImpl implements SlackService {
    @Value("${slack.webhook.urlOfMine}")
    private String webHookUrl;
    private RestTemplate restTemplate;

    public SlackServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //todo exception handling
    @Override
    public boolean sendMsg(String msg) {
        if(StringUtils.isEmpty(msg))
            return false;

        ResponseEntity<String> response = restTemplate.postForEntity(
                webHookUrl,
                new PayLoad(msg),
                String.class
        );

        return response.getStatusCode().is2xxSuccessful()
                && "ok".equalsIgnoreCase(response.getBody());
    }
}
