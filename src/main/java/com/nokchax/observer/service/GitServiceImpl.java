package com.nokchax.observer.service;

import com.nokchax.observer.domain.GitSearchApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GitServiceImpl implements GitService {
    @Value("${git.token}")
    private String token;
    @Value("${git.api.search.commentUrl}")
    private String searchCommentApiUrl;
    @Value("${git.api.search.commentQuery}")
    private String searchCommentApiQuery;
    private HttpEntity httpEntity;

    private RestTemplate restTemplate;

    @Autowired
    public GitServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public GitSearchApiResponse searchCommentsOfToday(String gitId) {
        System.out.println(getApiUrl(gitId, "2019-01-01"));
        ResponseEntity<GitSearchApiResponse> response = restTemplate.exchange(
                        getApiUrl(gitId, "2019-01-01"),
                        HttpMethod.GET,
                        httpEntity,
                        GitSearchApiResponse.class
                );

        return response.getBody();
    }

    private String getApiUrl(String gitId, String date) {
        return searchCommentApiUrl + getQuery(gitId, date);
    }

    private String getQuery(String gitId, String date) {
        return String.format(searchCommentApiQuery, gitId, date);
    }

    @PostConstruct
    private void init() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "application/vnd.github.cloak-preview");

        httpEntity = new HttpEntity(headers);
    }
}
