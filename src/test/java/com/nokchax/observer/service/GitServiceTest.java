package com.nokchax.observer.service;

import com.nokchax.observer.domain.GitSearchApiResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitServiceTest {
    @Mock
    private RestTemplate mockRestTemplate;
    @InjectMocks
    private GitService gitService = new GitServiceImpl(mockRestTemplate);

    @Value("${git.myID}")
    private String myID;

    @Before
    public void init() {
        ReflectionTestUtils.setField(gitService, "searchCommentApiUrl", "emptyString");
        ReflectionTestUtils.setField(gitService, "token", "emptyString");
        ReflectionTestUtils.setField(gitService, "searchCommentApiQuery", "emptyString");
        ReflectionTestUtils.setField(gitService, "httpEntity", new HttpEntity(new HttpHeaders()));
    }
    /*
    todo searchCommentTestOfToday test
     */
    @Test
    public void searchCommentTestOfToday() {
        initMock(new GitSearchApiResponse(1));

        GitSearchApiResponse apiResponse = gitService.searchCommentsOfToday(myID);
        assertThat(apiResponse.getCommitCount()).isEqualTo(1);
        assertThat(apiResponse.hasCommitted()).isEqualTo(true);
    }
    @Test
    public void searchCommentsTestOfCommittedDate() {
        initMock(new GitSearchApiResponse(1));

        GitSearchApiResponse apiResponse = gitService.searchComments(myID, LocalDate.of(2019, 1,1 ));
        assertThat(apiResponse.getCommitCount()).isEqualTo(1);
        assertThat(apiResponse.hasCommitted()).isEqualTo(true);
    }

    @Test
    public void searchCommentsTestOfNonCommittedDate() {
        initMock(new GitSearchApiResponse(0));

        GitSearchApiResponse apiResponse = gitService.searchComments(myID, LocalDate.of(2018, 3,1 ));
        assertThat(apiResponse.getCommitCount()).isEqualTo(0);
        assertThat(apiResponse.hasCommitted()).isEqualTo(false);
    }

    private void initMock(GitSearchApiResponse response) {
        Mockito.when(mockRestTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.eq(GitSearchApiResponse.class)
        )).thenReturn(new ResponseEntity(response, HttpStatus.OK));
    }
}
