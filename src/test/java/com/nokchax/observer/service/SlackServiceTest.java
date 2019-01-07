package com.nokchax.observer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlackServiceTest {
    @Autowired
    SlackService slackService;

    @Test
    public void sendMsgTest() {
        assertThat(slackService.sendMsg("observer app test")).isEqualTo(true);
    }

    @Test
    public void sendMsgFailTest() {
        assertThat(slackService.sendMsg("")).isEqualTo(false);
        assertThat(slackService.sendMsg(null)).isEqualTo(false);
    }
}
