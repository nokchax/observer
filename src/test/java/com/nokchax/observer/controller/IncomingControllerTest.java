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

    /*
    {
        token=HWw8VPW9WV7oU1sfQ3D1YTIc,
        team_id=TEW89TQA2,
        api_app_id=AF53X2LKG,
        event={
            client_msg_id=ecdb760a-301b-4ab2-8b90-4574df54a12b,
            type=message,
            text=hi,
            user=UEV2B9PD3,
            ts=1548416095.000200,
            channel=CEW89TU4E,
            event_ts=1548416095.000200,
            channel_type=channel
        },
        type=event_callback,
        event_id=EvFQ4S1XRV,
        event_time=1548416095,
        authed_users=[UEV2B9PD3]
    }
     */
    @Before
    public void init() {
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
