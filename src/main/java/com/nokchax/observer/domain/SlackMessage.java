package com.nokchax.observer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SlackMessage extends Message {
    private String token;

    public SlackMessage(String token, Message message) {
        super(message.getText(), message.getChannel());
        this.token = token;
    }
}
