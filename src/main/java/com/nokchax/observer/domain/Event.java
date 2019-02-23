package com.nokchax.observer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
https://api.slack.com/events/message
 */
@Data
@NoArgsConstructor
public class Event {
    private String type;
    private String channel;
    private String user;
    private String text;
    private String ts;

    public CommandType getCommandType() {
        return CommandType.getCommandType(this.text);
    }

    public Command getCommand() {
        return new Command(this.text);
    }
}
