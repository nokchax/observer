package com.nokchax.observer.controller;

import com.nokchax.observer.component.GitAlarm;
import com.nokchax.observer.service.TranslateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
mock mvc test link
https://meetup.toast.com/posts/124
https://stackoverflow.com/questions/18336277/how-to-check-string-in-response-body-with-mockmvc
 */
@WebMvcTest
@RunWith(SpringRunner.class)
public class SlackMessageControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    GitAlarm gitAlarm;
    @MockBean
    TranslateService papagoService;

    //todo mockmvc 로 controller를 테스트 할때 di 시켜줘야할 bean을 등록하는 법 공부

    /*
    As Slack sends your request URL events, we ask that you return a HTTP 200 OK for each event you successfully receive.
     */
    @Test
    public void botControllerTest() throws Exception {
        //language=JSON
        String requestJsonBody = "{\"type\" : \"message\", \"text\" : \"hi\", \"user\" : \"WEF123123\", \"ts\" : 1548416095.000200, \"channel\" : \"CEW8123UEW\", \"event_ts\" : 1548416095.000200, \"channel_type\" : \"channel\"}\n";
        //todo request json body change
        mvc.perform(
                post("/bot")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJsonBody)
        ).andExpect(status().isOk())
        .andDo(print());
    }
}
