package com.nokchax.observer.domain;


public enum Language {
    KO("ko"),
    EN("en");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
