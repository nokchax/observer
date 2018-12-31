package com.nokchax.observer.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Setter
@Service
public class GitServiceImpl implements GitService {
    @Value("${git.token}")
    private String token;
    private RestTemplate restTemplate;

    @PostConstruct
    public void test() {
        System.out.println(token);
    }
}
