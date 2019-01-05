package com.nokchax.observer.service;

import com.nokchax.observer.domain.GitSearchApiResponse;

public interface GitService {
    GitSearchApiResponse searchCommentsOfToday(String gitId);
}
