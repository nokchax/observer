package com.nokchax.observer.component;

import com.nokchax.observer.domain.GitSearchApiResponse;
import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.SlackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitAlarmTest {
    private GitAlarm gitAlarm;
    @Mock
    private GitService gitService;
    @Mock
    private SlackService slackService;

    @Before
    public void init() {
        gitAlarm = new GitAlarm(gitService, slackService);
    }
    //mock service를 생성해서 주입해줘야하나..?
    @Test
    public void pressWhenUserNotCommittedTest() {
        GitSearchApiResponse apiResponse = new GitSearchApiResponse(1);
        when(gitService.searchCommentsOfToday("nokchax")).thenReturn(apiResponse);
        when(slackService.sendMsg("Do it!")).thenReturn(true);

        assertThat(gitAlarm.hasCommittedToday()).isEqualTo(false);
        gitAlarm.checkCommit("nokchax");
        assertThat(gitAlarm.hasCommittedToday()).isEqualTo(true);
    }
}
