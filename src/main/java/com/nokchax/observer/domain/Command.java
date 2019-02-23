package com.nokchax.observer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@NoArgsConstructor
public class Command {
    private CommandType commandType;
    private String commandArgument;

    public Command(String command) {
        if(StringUtils.isEmpty(command))
            throw new IllegalArgumentException("Text must not be a null or empty");

        this.commandType = CommandType.getCommandType(command);
        this.commandArgument = getArgument(command);
    }

    //private 일경우 테스트는?
    private static String getArgument(String text) {
        if(!text.contains(" "))
            return "";

        return text.substring(text.indexOf(" ")).trim();
    }
}
