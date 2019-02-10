package com.nokchax.observer.domain;

import org.junit.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
public class CommandTypeTest {
    @Test
    public void getCommandTypeTest_TRANSLATE() {
        CommandType type = CommandType.getCommandType("/번역");

        assertThat(type).isEqualTo(CommandType.TRANSLATE);
    }

    @Test
    public void getCommandTypeTest_CHECKCOMMIT() {
        assertThat(CommandType.getCommandType("/커밋체크"))
                .isEqualTo(CommandType.COMMIT_CHECK);
    }

    @Test
    public void getCommandTypeTest_usingNull() {
        assertThat(CommandType.getCommandType(null))
                .isEqualTo(CommandType.NONE);
    }

    @Test
    public void getCommandTypeTest_usingEmptyString() {
        assertThat(CommandType.getCommandType(""))
                .isEqualTo(CommandType.NONE);
    }
}
