package com.nokchax.observer.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

// spring web을 실행시킬 필요가 없는데 이렇게 테스트하는게 맞을까?
@RunWith(SpringRunner.class)
@SpringBootTest
public class PapagoRequestBodyTest {
    @Test
    public void checkLanguageKO_test() {
        Language language = PapagoRequestBody.checkLanguage("이것은 한글인가?");

        assertThat(language).isEqualTo(Language.KO);
    }
}
