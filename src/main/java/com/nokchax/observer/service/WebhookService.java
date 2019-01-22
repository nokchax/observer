package com.nokchax.observer.service;

public interface WebhookService {
    //send slack msg
    boolean sendMsg(String msg);
}
