package com.nokchax.observer.domain;

import org.junit.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
public class CommandTypeTest {
    @Test
    public void getCommandWithEventType() {
        CommandType type = CommandType.getCommandType("/번역");

        assertThat(type).isEqualTo(CommandType.TRANSLATE);
    }
}
