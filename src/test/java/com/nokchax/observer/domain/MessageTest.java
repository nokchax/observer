package com.nokchax.observer.domain;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageTest {
    @Test
    public void constructorTest() {
        Message message = new Message("text", "channel");

        assertThat(message.getText()).isEqualTo("text");
        assertThat(message.getChannel()).isEqualTo("channel");
    }
}
