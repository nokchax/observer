package com.nokchax.observer.service;

import com.nokchax.observer.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlackMessengerServiceTest {
    /*
    send message test
    slack message api return when 200 ok
    {
        "ok": true,
        "channel": "CEW89TU4E",
        "ts": "1548072829.000500",
        "message": {
            "type": "message",
            "subtype": "bot_message",
            "text": "123",
            "ts": "1548072829.000500",
            "username": "observer",
            "bot_id": "BF3GL258U"
        }
    }
     */

    @Autowired
    SlackMessengerService slackMessengerService;

    @Value("${slack.api.privateChannel}")
    private String privateChannel;

    @Test
    public void sendMessageTest() {
        Message message = new Message("test message", privateChannel);
        assertThat(slackMessengerService.sendMessage(message))
                .isEqualTo(true);
    }

    @Test
    public void sendKoreanMessageTest() {
        Message message = new Message("한글", privateChannel);
        assertThat(slackMessengerService.sendMessage(message))
                .isEqualTo(true);
    }
}
