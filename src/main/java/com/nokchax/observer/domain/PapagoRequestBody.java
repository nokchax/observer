package com.nokchax.observer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class PapagoRequestBody {
    private static final String form = "source=%s&target=%s&text=%s";
    private Language source;
    private Language target;
    @NotBlank
    private String text;

    public PapagoRequestBody(String text) {
    }

    public static Language checkLanguage(String text) {

        return text.chars()
                .anyMatch(x -> x > 127) ? Language.KO : Language.EN;
    }
}
