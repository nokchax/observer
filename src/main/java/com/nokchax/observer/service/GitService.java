package com.nokchax.observer.service;

import com.nokchax.observer.domain.GitSearchApiResponse;

import java.time.LocalDate;

public interface GitService {
    GitSearchApiResponse searchCommentsOfToday(String gitId);
    GitSearchApiResponse searchComments(String gitId, LocalDate date);
}
