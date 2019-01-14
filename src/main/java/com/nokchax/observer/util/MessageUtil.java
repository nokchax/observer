package com.nokchax.observer.util;

import com.nokchax.observer.domain.GitSearchApiResponse;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MessageUtil {
    private static final List<String> PRESS_MESSAGES = Arrays.asList(
            "Do commit",
            "커밋... 안하시나요?",
            "누구인가? 누가 감히 커밋도 안하고 놀아?"
    );
    private static final List<String> CELEBRATION_MESSAGES = Arrays.asList(
            "Commit complete :)",
            "수고하셨습니다."
    );

    public static String getRandomPressMessage() {
        return PRESS_MESSAGES.get(ThreadLocalRandom.current().nextInt(PRESS_MESSAGES.size()));
    }

    public static String getRandomCelebrationMessage() {
        return CELEBRATION_MESSAGES.get(ThreadLocalRandom.current().nextInt(CELEBRATION_MESSAGES.size()));
    }

    public static String getMessageByGitApiResponse(GitSearchApiResponse apiResponse) {
        return apiResponse.hasCommitted() ? getRandomCelebrationMessage() : getRandomPressMessage();
    }
}
