package com.nokchax.observer.domain;

import org.springframework.util.StringUtils;

public enum CommandType {
    TRANSLATE,
    COMMIT_CHECK,
    NONE;
    //make command type using eventType's text

    public static CommandType getCommandType(String text) {
        String command = getCommand(text);
        if(StringUtils.isEmpty(command) || !command.startsWith("/"))
            return NONE;

        switch (command) {
            case "/번역" :
                return TRANSLATE;
            case "/커밋체크":
                return COMMIT_CHECK;
            default:
                return NONE;
        }
    }

    private static String getCommand(String command) {
        if(StringUtils.isEmpty(command))
            return "";

        String[] args = command.split(" ");

        return args[0];
    }
}
