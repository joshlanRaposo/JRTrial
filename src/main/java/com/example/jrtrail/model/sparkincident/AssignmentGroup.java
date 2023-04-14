package com.example.jrtrail.model.sparkincident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentGroup {
    @JsonProperty("display_value")
    private String displayValue;
    @JsonProperty("link")
    private String link;
}
