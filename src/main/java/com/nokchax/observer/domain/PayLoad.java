package com.nokchax.observer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@NoArgsConstructor
public class PayLoad {
    //@NotNull, NotBlank can be apply just bean
    private String text;

    public PayLoad(String text) {
        if(StringUtils.isEmpty(text))
            throw new IllegalArgumentException("Text must not be a null or empty");
    }
}
