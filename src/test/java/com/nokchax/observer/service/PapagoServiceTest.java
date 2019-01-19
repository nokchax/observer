package com.nokchax.observer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PapagoServiceTest {
    @Autowired
    private TranslateService papagoService;

    //한국어를 입력 받으면 영어로 번역된 결과를 리턴한다.
    @Test
    public void translateKoToEnTest() {
        assertThat(papagoService.translate("사과"))
                .isEqualTo("apple");
    }

    //영어를 입력 받으면 한국어로 번역된 결과를 리턴한다.
    @Test
    public void translateEnToKoTest() {
        assertThat(papagoService.translate("apple"))
                .isEqualTo("사과");
    }
}
