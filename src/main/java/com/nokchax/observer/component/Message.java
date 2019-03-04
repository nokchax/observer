package com.nokchax.observer.component;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties("message")
public class Message {
    private List<String> press;
    private List<String> celebration;

    public void printPress() {
        press.stream().forEach(System.out::println);
        celebration.stream().forEach(System.out::println);
    }
    /*
    xxxx
    compileOnly('org.springframework.boot:spring-boot-configuration-processor')
    getter, setter 추가시 동작
     */
}
