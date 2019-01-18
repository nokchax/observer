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

    //
    @Test
    public void translateKoToEnTest() {
        //한국어를 입력 받으면 영어를 리턴한다.
        String translatedWord = papagoService.translate("사과");

        assertThat(translatedWord).isEqualTo("apple");
    }

    @Test
    public void translateEnToKoTest() {

    }
}
