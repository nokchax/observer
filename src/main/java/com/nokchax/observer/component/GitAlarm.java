package com.nokchax.observer.component;

import com.nokchax.observer.domain.GitSearchApiResponse;
import com.nokchax.observer.service.GitService;
import com.nokchax.observer.service.MessageService;
import com.nokchax.observer.service.WebhookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class GitAlarm {
    private GitService gitService;
    private WebhookService slackService;
    private MessageService messageService;
    private boolean hasCommittedToday = false;

    @Value("${git.myID}")
    private String myID;

    public GitAlarm(GitService gitService, WebhookService slackService, MessageService messageService) {
        this.gitService = gitService;
        this.slackService = slackService;
        this.messageService = messageService;
    }

    //scheduled annotation not allow method that has argument
    @Scheduled(cron = "0 59 12,19,20,21,22 * * *")
    public void checkMyCommit() {
        checkCommit(this.myID);
    }

    public void checkCommit(String userId) {
        log.info("Start check commit flag : {}", this.hasCommittedToday);
        if(hasCommittedToday)
            return;

        checkCommitAndSendMsg(userId);
    }

    private void checkCommitAndSendMsg(String userId) {
        log.info("Send Msg");
        GitSearchApiResponse myCommitResponse = gitService.searchCommentsOfToday(userId);

        slackService.sendMsg(messageService.getMessageByGitApiResponse(myCommitResponse));

        this.hasCommittedToday = myCommitResponse.hasCommitted();
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void init() {
        log.info("Start Init commit flag : {}", this.hasCommittedToday);
        this.hasCommittedToday = false;
        log.info("end Init commit flag : {}", this.hasCommittedToday);
    }

    public boolean hasCommittedToday() {
        return this.hasCommittedToday;
    }
}
