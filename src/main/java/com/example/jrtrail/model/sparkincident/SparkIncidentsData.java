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
public class SparkIncidentsData {
    @JsonProperty("number")
    private String number;
    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("assignment_group")
    private AssignmentGroup assignmentGroup;
    @JsonProperty("incident_state")
    private String incidentState;
    @JsonProperty("urgency")
    private String urgency;
    @JsonProperty("impact")
    private String impact;
    @JsonProperty("state")
    private String state;
}
