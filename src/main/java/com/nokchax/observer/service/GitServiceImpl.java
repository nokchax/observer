package com.nokchax.observer.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Setter
@Service
public class GitServiceImpl implements GitService {
    private RestTemplate restTemplate;
}
