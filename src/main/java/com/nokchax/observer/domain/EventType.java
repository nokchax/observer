package com.nokchax.observer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("team_id")
    private String teamId;
    @JsonProperty("api_app_id")
    private String apiAppId;
    private Event event;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("event_time")
    private Integer eventTime;
    @JsonProperty("authed_users")
    private List<String> authedUsers;

    public CommandType getCommandType() {
        return event.getCommandType();
    }
}