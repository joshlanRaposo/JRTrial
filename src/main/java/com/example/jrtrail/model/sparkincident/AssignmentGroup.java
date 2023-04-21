package com.example.jrtrail.model.sparkincident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentGroup {
    @JsonProperty("display_value")
    private String displayValue;
    @JsonProperty("link")
    private String link;
}
