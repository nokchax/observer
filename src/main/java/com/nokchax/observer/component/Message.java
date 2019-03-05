package com.nokchax.observer.component;


import com.nokchax.observer.domain.GitSearchApiResponse;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    public String getRandomPressMessage() {
        return press.get(ThreadLocalRandom.current().nextInt(press.size()));
    }

    public String getRandomCelebrationMessage() {
        return celebration.get(ThreadLocalRandom.current().nextInt(celebration.size()));
    }

    public String getMessageByGitApiResponse(GitSearchApiResponse apiResponse) {
        return apiResponse.hasCommitted() ? getRandomCelebrationMessage() : getRandomPressMessage();
    }
    /*
    xxxx
    compileOnly('org.springframework.boot:spring-boot-configuration-processor')
    getter, setter 추가시 동작
     */
}
