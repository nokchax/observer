package com.nokchax.observer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebhookServiceTest {
    @Autowired
    WebhookService slackMessageService;
    @Autowired
    MessageService messageService;

    @Test
    public void sendMsgTest() {
        assertThat(slackMessageService.sendMsg(messageService.getRandomPressMessage())).isEqualTo(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sendMsgFailTestWithEmptyMsg() {
        assertThat(slackMessageService.sendMsg("")).isEqualTo(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sendMsgFailTestWithNullParam() {
        assertThat(slackMessageService.sendMsg(null)).isEqualTo(false);
    }
}
