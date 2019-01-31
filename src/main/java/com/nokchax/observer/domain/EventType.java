package com.nokchax.observer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
https://api.slack.com/types/event
{
        "token": "XXYYZZ",
        "team_id": "TXXXXXXXX",
        "api_app_id": "AXXXXXXXXX",
        "event": {
                "type": "name_of_event",
                "event_ts": "1234567890.123456",
                "user": "UXXXXXXX1"
        },
        "type": "event_callback",
        "authed_users": [
                "UXXXXXXX1",
                "UXXXXXXX2"
        ],
        "event_id": "Ev08MFMKH6",
        "event_time": 1234567890
}
 */
@Data
@NoArgsConstructor
public class EventType {
    private String token;
    private String teamId;
    private String apiAppId;
    private Event event;
    private String eventId;
    private Integer eventTime;
    private List<String> authedUsers;

    /*
    https://api.slack.com/events/message
     */
    @Data
    @NoArgsConstructor
    class Event {
        private String type;
        private String channel;
        private String user;
        private String text;
        private String ts;
    }
}