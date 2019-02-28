package com.nokchax.observer.component;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("message")
public class Message {
    private List<String> press = new ArrayList<>();
    //private List<String> celebration = new ArrayList<>();

    public void printPress() {
        press.stream().forEach(System.out::println);
    }

    /*
    compileOnly('org.springframework.boot:spring-boot-configuration-processor')
    의존성을 추가하지 않으면 getXXX() 가 필요하다.
    하지만 의존성을 추가했을 때는 없어도 동작한다
     */
/*    public List<String> getPress() {
        return this.press;
    }*/
}
