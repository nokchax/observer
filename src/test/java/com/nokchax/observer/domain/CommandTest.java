package com.nokchax.observer.domain;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommandTest {
    @Test
    public void commandTest() {
        Command command = new Command("@번역 사과");
        assertThat(command.getCommandType())
                .isEqualTo(CommandType.TRANSLATE);
        assertThat(command.getCommandArgument())
                .isEqualTo("사과");
    }

    @Test
    public void argumentTest() {
        assertThat(new Command("@번역").getCommandArgument())
                .isEqualTo("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest_EmptyString() {
        new Command("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentTest_NULL() {
        new Command(null);
    }
}
