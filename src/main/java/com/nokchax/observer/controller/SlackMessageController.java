package com.nokchax.observer.controller;

import com.nokchax.observer.domain.EventType;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Setter
@RestController
public class SlackMessageController {

    // todo 예외가 발생하면 controller advice에서 잡아서 error 메세지를 체널로 응답한다.
    // todo spring @Controller / @RequestMapping 처럼 필터에서 미리 데이터를 받아서 DISPATCH 시킬 수 있게 만들기
    @PostMapping("/bot")
    public String incoming(@RequestBody EventType eventType) {
        //todo check token from slack filter level
        System.out.println(eventType);

        return eventType.toString();
    }
}
