package com.nokchax.observer.component;

import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.SlackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Slf4j
@Component
public class GitAlarm {
    private GitService gitService;
    private SlackService slackService;
    private boolean hasCommittedToday = false;

    public GitAlarm(GitService gitService, SlackService slackService) {
        this.gitService = gitService;
        this.slackService = slackService;
    }

    public boolean hasCommittedToday() {
        return this.hasCommittedToday;
    }

    @PostConstruct
    public void init() {

    }
}
