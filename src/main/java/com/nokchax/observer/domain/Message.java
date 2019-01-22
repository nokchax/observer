package com.nokchax.observer.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Message {
    private String message;
    private String channel;

    public Message(String message) {
        this.message = message;
    }
    public Message(String message, String channel) {
        this.message = message;
        this.channel = channel;
    }
}
