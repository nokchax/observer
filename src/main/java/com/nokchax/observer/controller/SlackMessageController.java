package com.nokchax.observer.controller;

import com.nokchax.observer.component.GitAlarm;
import com.nokchax.observer.domain.Command;
import com.nokchax.observer.domain.EventType;
import com.nokchax.observer.service.TranslateService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Setter
@RestController
public class SlackMessageController {
    private GitAlarm gitAlarm;
    private TranslateService translateService;

    public SlackMessageController(GitAlarm gitAlarm, TranslateService translateService) {
        this.gitAlarm = gitAlarm;
        this.translateService = translateService;
    }

    // todo 예외가 발생하면 controller advice에서 잡아서 error 메세지를 체널로 응답한다.
    // todo spring @Controller / @RequestMapping 처럼 필터에서 미리 데이터를 받아서 DISPATCH 시킬 수 있게 만들기
    @PostMapping("/bot")
    public String incoming(@RequestBody EventType eventType) {
        //todo check token from slack filter level
        System.out.println(eventType);
        //text의 prefix에 따라 처리하기..

        Command command = eventType.getCommand();
        switch(command.getCommandType()) {
            case COMMIT_CHECK:
                gitAlarm.checkMyCommit();
                break;
            case TRANSLATE:
                translateService.translate(command.getCommandArgument());
                break;
            default:

        }

        return eventType.toString();
    }
}
