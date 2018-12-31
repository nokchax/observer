package com.nokchax.observer.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Setter
@Service
@Slf4j
public class GitServiceImpl implements GitService {
    @Value("${git.token}")
    private String token;
    private RestTemplate restTemplate;

    @PostConstruct
    public void test() {
        log.info(token);
    }
}
