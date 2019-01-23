package com.nokchax.observer.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Message {
    private String text;
    private String channel;

    public Message(String text) {
        this.text = text;
    }
    public Message(String text, String channel) {
        this.text = text;
        this.channel = channel;
    }
}
