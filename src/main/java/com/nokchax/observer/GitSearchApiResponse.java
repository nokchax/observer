package com.nokchax.observer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class GitSearchApiResponse {
    @Min(0)
    @JsonProperty("totalCount")
    private int commitCount;

    public boolean hasCommitted() {
        return 0 < commitCount;
    }
}
