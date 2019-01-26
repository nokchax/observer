package com.nokchax.observer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/*
mock mvc test link
https://meetup.toast.com/posts/124
https://stackoverflow.com/questions/18336277/how-to-check-string-in-response-body-with-mockmvc
 */
@WebMvcTest
@RunWith(SpringRunner.class)
public class IncomingControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void botControllerTest() throws Exception {
        mvc.perform(
                post("/bot")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"hi\":\"hi\"}")
        );

        //.Expect()~~
    }
}
