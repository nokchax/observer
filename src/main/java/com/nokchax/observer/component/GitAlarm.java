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

    //todo scheduling
    public void checkCommit(String userId) {
        if(hasCommittedToday())
            return;

        //send msg using message loader?
        if(gitService.searchCommentsOfToday(userId).hasCommitted())
            sendMsg("Do it!");
    }

    private void sendMsg(String msg) {
        if(slackService.sendMsg(msg))
            this.hasCommittedToday = true;
    }

    public boolean hasCommittedToday() {
        return this.hasCommittedToday;
    }

    //todo scheduling when 00:00 then init commit flag false
    public void init() {

    }
}
