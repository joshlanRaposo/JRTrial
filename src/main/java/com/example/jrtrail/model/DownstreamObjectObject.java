package com.example.jrtrail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DownstreamObjectObject {
    @JsonProperty("downstream-services")
    private Map<String, Map<String, String>> downstreamService = new HashMap<>();
}
