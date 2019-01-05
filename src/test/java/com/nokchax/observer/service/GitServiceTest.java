package com.nokchax.observer.service;

import com.nokchax.observer.domain.GitSearchApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitServiceTest {
    @Autowired
    private GitService gitService;

    @Test
    public void test() {
        GitSearchApiResponse apiResponse = gitService.searchCommentsOfToday("nokchax");
        assertThat(apiResponse.getCommitCount()).isEqualTo(3);
        assertThat(apiResponse.hasCommitted()).isEqualTo(true);
    }
}
