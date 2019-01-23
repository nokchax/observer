package com.nokchax.observer.service;

import com.nokchax.observer.domain.Message;
import org.springframework.stereotype.Service;

/*
    send msg using message api
 */
@Service
public class SlackMessengerService implements MessengerService {
    @Override
    public boolean sendMessage(Message message) {
        return false;
    }
}
