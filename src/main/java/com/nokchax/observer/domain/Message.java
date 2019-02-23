package com.nokchax.observer.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@Builder
@NoArgsConstructor
public class Message {
    private String text;
    private String channel;

    public Message(String text) {
        if(StringUtils.isEmpty(text))
            throw new IllegalArgumentException("Text must not be a null or empty");

        this.text = text;
    }
    public Message(String text, String channel) {
        this(text);
        this.channel = channel;
    }
}
