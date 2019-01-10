package com.nokchax.observer.component;

import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.SlackService;
import com.nokchax.observer.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


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

    //scheduled annotation not allow method that has argument
    @Scheduled(cron = "0 59 12,19,21,23 * * *")
    public void checkMyCommit() {
        checkCommit("nokchax");
    }

    public void checkCommit(String userId) {
        log.info("Start check commit flag : {}", this.hasCommittedToday);
        if(hasCommittedToday())
            return;

        //send msg using message loader?
        if(gitService.searchCommentsOfToday(userId).hasCommitted())
            sendMsg(MessageUtil.getRandomPressMessage());
    }

    private void sendMsg(String msg) {
        log.info("Send Msg");
        if(slackService.sendMsg(msg))
            this.hasCommittedToday = true;
    }

    public boolean hasCommittedToday() {
        return this.hasCommittedToday;
    }

    //todo scheduling when 00:00 then init commit flag false
    @Scheduled(cron = "0 0 0 * * *")
    public void init() {
        log.info("Start Init commit flag : {}", this.hasCommittedToday);
        this.hasCommittedToday = false;
        log.info("end Init commit flag : {}", this.hasCommittedToday);
    }
}
