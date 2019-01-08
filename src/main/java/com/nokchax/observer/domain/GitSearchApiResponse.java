package com.nokchax.observer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class GitSearchApiResponse {
    @Min(0)
    @JsonProperty("total_count")
    private int commitCount;

    public GitSearchApiResponse(int commitCount) {
        this.commitCount = commitCount;
    }

    public boolean hasCommitted() {
        return 0 < commitCount;
    }
}
