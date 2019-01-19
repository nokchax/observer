package com.nokchax.observer.domain;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
public class PapagoRequestBodyTest {
    @Test
    public void makeRequestBodyTestWithKO() {
        assertThat(new PapagoRequestBody("사과").toBody())
                .isEqualTo("source=ko&target=en&text=사과");
    }

    @Test
    public void makeRequestBodyTestWithEN() {
        assertThat(new PapagoRequestBody("apple").toBody())
                .isEqualTo("source=en&target=ko&text=apple");
    }
}
