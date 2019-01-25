package com.nokchax.observer.controller;

import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.WebhookService;
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
    private WebhookService slackService;

    @Autowired
    public IncomingController(GitService gitService, WebhookService slackService) {
        this.gitService = gitService;
        this.slackService = slackService;
    }

    // todo 예외가 발생하면 controller advice에서 잡아서 error 메세지를 체널로 응답한다.
    // todo spring @Controller / @RequestMapping 처럼 필터에서 미리 데이터를 받아서 DISPATCH 시킬 수 있게 만들기
    @PostMapping("/bot")
    public Map<String, Object> incoming(@RequestBody Map<String, Object> body) {
        //todo check token from slack filter level
        log.info("{}", body);

        return body;
    }
}
