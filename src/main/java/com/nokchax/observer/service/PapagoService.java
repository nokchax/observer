package com.nokchax.observer.service;

import org.springframework.stereotype.Service;

@Service
public class PapagoService implements TranslateService {
    @Override
    public String translate(String word) {
        return "apple";
    }
    //todo translate word, sentence using papago api
}
