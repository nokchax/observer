package com.nokchax.observer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

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

    private ObjectMapper objectMapper = new ObjectMapper();

    private Map<String, Object> requestBody = new HashMap<>();

    @Before
    public void init() {
        //request body를 좀 더 깔끔하게 할순 없을까
        //https://stackoverflow.com/questions/30691949/how-to-inject-a-map-using-the-value-spring-annotation
        Map<String, Object> event = new HashMap<>();

        event.put("type", "message");
        event.put("text", "hi");
        event.put("user", "WEF123123");
        event.put("ts", 1548416095.000200);
        event.put("channel", "CEW8123UEW");
        event.put("event_ts", 1548416095.000200);
        event.put("channel_type", "channel");

        requestBody.put("event", event);
    }

    @Test
    public void botControllerTest() throws Exception {
        mvc.perform(
                post("/bot")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody))
        );

        //.Expect()~~
    }
}
