package com.example.jrtrail.controller;

import com.example.jrtrail.config.DynamoDBConfig;
import com.example.jrtrail.model.downstream.LivenessStatusMap;
import com.example.jrtrail.service.DownstreamService;
import com.example.jrtrail.service.LivenessStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DownstreamController {
    private final DownstreamService downstreamService;
    private final LivenessStatusService service;

    public DownstreamController(DownstreamService downstreamService, LivenessStatusService service) {
        this.downstreamService = downstreamService;
        this.service = service;
    }

    @PostMapping("/status")
    public ResponseEntity<LivenessStatusMap> addApplication() {
        DynamoDBConfig extSpringData = new DynamoDBConfig();
        LivenessStatusMap s = downstreamService.save();

        extSpringData.dynamoDBMapper().save(s);

        return ResponseEntity.ok(downstreamService.save());
    }

    @GetMapping("/showStatus")
    public ResponseEntity<Iterable<LivenessStatusMap>> dis() {
        return ResponseEntity.ok(service.findAll());
    }
}
