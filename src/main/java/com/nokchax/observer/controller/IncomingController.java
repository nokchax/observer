package com.nokchax.observer.controller;

import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.MessengerService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@Setter
@RestController
public class IncomingController {
    private GitService gitService;
    private MessengerService slackService;

    @Autowired
    public IncomingController(GitService gitService, MessengerService slackService) {
        this.gitService = gitService;
        this.slackService = slackService;
    }

    @PostMapping("/bot")
    public Map<String, Object> incoming(@RequestBody Map<String, Object> body) {
        //todo check token from slack filter level
        log.info("{}", body);

        return body;
    }
}
