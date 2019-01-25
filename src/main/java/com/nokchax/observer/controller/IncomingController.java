package com.nokchax.observer.controller;

import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.SlackMessengerService;
import com.nokchax.observer.service.WebhookService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
{
    token=HWw8VPW9WV7oU1sfQ3D1YTIc,
    team_id=TEW89TQA2,
    api_app_id=AF53X2LKG,
    event={
        client_msg_id=ecdb760a-301b-4ab2-8b90-4574df54a12b,
        type=message,
        text=hi,
        user=UEV2B9PD3,
        ts=1548416095.000200,
        channel=CEW89TU4E,
        event_ts=1548416095.000200,
        channel_type=channel
    },
    type=event_callback,
    event_id=EvFQ4S1XRV,
    event_time=1548416095,
    authed_users=[UEV2B9PD3]
}
 */

@Slf4j
@Setter
@RestController
public class IncomingController {
    private GitService gitService;
    private SlackMessengerService slackMessengerService;

    @Autowired
    public IncomingController(GitService gitService, SlackMessengerService slackMessengerService) {
        this.gitService = gitService;
        this.slackMessengerService = slackMessengerService;
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
