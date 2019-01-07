package com.nokchax.observer.service;

import org.springframework.stereotype.Service;

@Service
public class SlackServiceImpl implements SlackService {
    @Override
    public boolean sendMsg(String msg) {
        return false;
    }
}
