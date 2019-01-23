package com.nokchax.observer.service;

import com.nokchax.observer.domain.Message;

public interface MessengerService {
    boolean sendMessage(Message message);
}
