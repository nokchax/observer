package com.nokchax.observer.controller;

import com.nokchax.observer.component.GitAlarm;
import com.nokchax.observer.service.TranslateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    @Test
    public void testChallengeTest() throws Exception {
        //language=JSON
        String requestJsonBody = "{\"token\": \"HWw8VOijfweoifjoC\", \"teamId\": \"TEI89TA2\", \"apiAppId\": \"AF83X2OID\", \"event\" : {\"type\": \"message\", \"channel\": \"COW89AW8E\", \"user\": \"ISO982PI3\", \"text\": \"@커밋체크\", \"ts\": 1550665259.000200}, \"eventId\": \"IvPE24G8Cg\", \"eventTime\": 1550665259, \"authedUsers\": [\"UES2P9DK3\"], \"challenge\":  \"1234567890\"}\n";
        mvc.perform(
                post("/bot")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJsonBody)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.challenge", is("1234567890")))
                .andDo(print());

        //todo response
    }

    /*
    As Slack sends your request URL events, we ask that you return a HTTP 200 OK for each event you successfully receive.
     */
    @Test
    public void botControllerTest() throws Exception {
        //language=JSON
        String requestJsonBody = "{\"token\": \"HWw8VOijfweoifjoC\", \"teamId\": \"TEI89TA2\", \"apiAppId\": \"AF83X2OID\", \"event\" : {\"type\": \"message\", \"channel\": \"COW89AW8E\", \"user\": \"ISO982PI3\", \"text\": \"@커밋체크\", \"ts\": 1550665259.000200}, \"eventId\": \"IvPE24G8Cg\", \"eventTime\": 1550665259, \"authedUsers\": [\"UES2P9DK3\"]}\n";
        /*
        mock bean에서 메소드가 실행된 것을 테스트하려면..?
        Mockito.verify() 를 사용하자
         */
        performMvc(requestJsonBody);
        Mockito.verify(gitAlarm).checkMyCommit();
    }

    @Test
    public void translateTest() throws Exception {
        //language=JSON
        String requestJsonBody = "{\"token\": \"HWw8VOijfweoifjoC\", \"teamId\": \"TEI89TA2\", \"apiAppId\": \"AF83X2OID\", \"event\" : {\"type\": \"message\", \"channel\": \"COW89AW8E\", \"user\": \"ISO982PI3\", \"text\": \"@번역\", \"ts\": 1550665259.000200}, \"eventId\": \"IvPE24G8Cg\", \"eventTime\": 1550665259, \"authedUsers\": [\"UES2P9DK3\"]}\n";

        performMvc(requestJsonBody);
        // mock bean의 메소드중 parameter가 존재하는 메소드의 테스트는?
        // any()
        Mockito.verify(papagoService).translate(any());
    }

    private void performMvc(String requestJsonBody) throws Exception {
        mvc.perform(
                post("/bot")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJsonBody)
        ).andExpect(status().isOk())
                .andDo(print());
    }
}
