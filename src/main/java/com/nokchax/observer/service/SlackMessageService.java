package com.nokchax.observer.service;

import org.springframework.stereotype.Service;

/*
    send msg using message api
 */
@Service
public class SlackMessageService implements MessengerService {
    @Override
    public boolean sendMsg(String msg) {
        return false;
    }
}
