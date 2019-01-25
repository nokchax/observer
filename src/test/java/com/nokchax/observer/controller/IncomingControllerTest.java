package com.nokchax.observer.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest
@SpringBootTest
public class IncomingControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void botControllerTest() throws Exception {
        mvc.perform(
                post("/bot")
                .contentType(MediaType.APPLICATION_JSON)
        );

        //.Expect()~~
    }
}
