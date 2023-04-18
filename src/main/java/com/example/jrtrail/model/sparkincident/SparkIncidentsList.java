package com.example.jrtrail.model.sparkincident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SparkIncidentsList {
    @JsonProperty("result")
    private List<SparkIncidentsData> results = new ArrayList<>();
}
