package com.nokchax.observer.service;

import com.nokchax.observer.domain.GitSearchApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitServiceTest {
    @Autowired
    private GitService gitService;

    @Value("${git.myID}")
    private String myID;

    /*
    todo searchCommentTestOfToday test
     */
    @Test
    public void searchCommentsTestOfCommittedDate() {
        GitSearchApiResponse apiResponse = gitService.searchComments(myID, LocalDate.of(2019, 1,1 ));
        assertThat(apiResponse.getCommitCount()).isEqualTo(1);
        assertThat(apiResponse.hasCommitted()).isEqualTo(true);
    }

    @Test
    public void searchCommentsTestOfNonCommittedDate() {
        GitSearchApiResponse apiResponse = gitService.searchComments(myID, LocalDate.of(2018, 3,1 ));
        assertThat(apiResponse.getCommitCount()).isEqualTo(1);
        assertThat(apiResponse.hasCommitted()).isEqualTo(true);
    }
}
