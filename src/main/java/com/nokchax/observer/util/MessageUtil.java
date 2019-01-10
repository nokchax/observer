package com.nokchax.observer.util;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MessageUtil {
    private static final List<String> PRESS_MESSAGES = Arrays.asList(
            "Do commit",
            "커밋... 안하시나요?",
            "누구인가? 누가 감히 커밋도 안하고 놀아?"
    );

    public static String getRandomPressMessage() {
        return PRESS_MESSAGES.get(ThreadLocalRandom.current().nextInt(PRESS_MESSAGES.size()));
    }
}
