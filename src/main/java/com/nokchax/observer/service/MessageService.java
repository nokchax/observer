package com.nokchax.observer.service;

import com.nokchax.observer.domain.GitSearchApiResponse;

public interface MessageService {
    String getRandomPressMessage();
    String getRandomCelebrationMessage();
    String getMessageByGitApiResponse(GitSearchApiResponse apiResponse);
}
