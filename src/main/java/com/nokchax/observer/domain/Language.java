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

    public Language getPair() {
        switch(this) {
            case KO:
                return EN;
            case EN:
                return KO;
            default:
        }
        return null;
    }

    public static Language checkLanguage(String text) {

        return text.chars()
                .anyMatch(x -> x > 127) ? KO : EN;
    }
}
