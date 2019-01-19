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
    /*
    현재는 영어 문장이 아닐 경우는 무조건 한글로 판단하도록 한다.
     */
    @Test
    public void checkLanguageKO_test() {
        assertThat(Language.checkLanguage("이것은 한글인가?"))
                .isEqualTo(Language.KO);
    }

    @Test
    public void checkLanguageEN_test() {
        assertThat(Language.checkLanguage("Is this English?"))
                .isEqualTo(Language.EN);
    }

    @Test
    public void checkLanguageWithNonAlphabet() {
        assertThat(Language.checkLanguage("Is this English!?'\"!@#$%^&*()-=+`~"))
                .isEqualTo(Language.EN);
    }

    @Test
    public void getPairLanguage_EN_TO_KO() {
        assertThat(Language.EN.getPair())
                .isEqualTo(Language.KO);
    }

    @Test
    public void getPairLanguage_KO_TO_EN() {
        assertThat(Language.KO.getPair())
                .isEqualTo(Language.EN);
    }
}
