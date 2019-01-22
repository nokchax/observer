package com.nokchax.observer.component;

import com.nokchax.observer.domain.GitSearchApiResponse;
import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.WebhookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitAlarmTest {
    private GitAlarm gitAlarm;
    private GitSearchApiResponse apiResponseOfCommittedUser = new GitSearchApiResponse(1);
    private GitSearchApiResponse apiResponseOfNonCommittedUser = new GitSearchApiResponse(0);
    @Mock
    private GitService gitService;
    @Mock
    private WebhookService slackService;
    @Value("${git.myID}")
    private String myID;

    /*
    when mock method accept any type of args use any(class) or (class)notNull()
    https://stackoverflow.com/questions/5969630/can-mockito-stub-a-method-without-regard-to-the-argument
     */
    @Before
    public void init() {
        gitAlarm = new GitAlarm(gitService, slackService);
        when(slackService.sendMsg((String)notNull())).thenReturn(true);
    }

    @Test
    public void pressWhenUserNotCommittedTest() {
        when(gitService.searchCommentsOfToday(myID)).thenReturn(apiResponseOfCommittedUser);

        assertThat(gitAlarm.hasCommittedToday()).isEqualTo(false);
        gitAlarm.checkCommit(myID);
        assertThat(gitAlarm.hasCommittedToday()).isEqualTo(true);
    }

    @Test
    public void skipWhenUserCommittedTest() {
        when(gitService.searchCommentsOfToday(myID)).thenReturn(apiResponseOfNonCommittedUser);

        assertThat(gitAlarm.hasCommittedToday()).isEqualTo(false);
        gitAlarm.checkCommit(myID);
        assertThat(gitAlarm.hasCommittedToday()).isEqualTo(false);
    }

    //todo how to test scheduling?
}
