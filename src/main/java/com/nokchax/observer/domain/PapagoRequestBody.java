package com.nokchax.observer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class PapagoRequestBody {
    private static final String form = "source=%s&target=%s&text=%s";
    private Language source;
    private Language target;
    private String text;

    public PapagoRequestBody(String text) {
        if(StringUtils.isEmpty(text))
            throw new IllegalArgumentException("Text must not be a null or empty");

        this.source = Language.checkLanguage(text);
        this.target = source.getPair();
        this.text = text;
    }

    public String toBody() {
        return String.format(form, source.getLanguage(), target.getLanguage(), text);
    }
}
