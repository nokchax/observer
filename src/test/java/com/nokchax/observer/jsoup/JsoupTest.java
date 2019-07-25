package com.nokchax.observer.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

public class JsoupTest {
    @Test
    public void jsoupTest() throws IOException {
        Document document = Jsoup.connect("https://naver.com").get();
        System.out.println(document.toString());
    }
}
