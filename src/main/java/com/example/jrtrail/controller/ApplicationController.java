package com.example.jrtrail.controller;

import com.example.jrtrail.config.DynamoDBConfig;
import com.example.jrtrail.model.application.Application;
import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.service.ApplicationService;
import com.example.jrtrail.service.DownstreamService;
import com.example.jrtrail.service.SparkIncidentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
public class ApplicationController {
    private final ApplicationService applicationService;
    private final SparkIncidentsService sparkIncidentsService;
    private final DownstreamService downstreamService;

    public ApplicationController(ApplicationService applicationService, SparkIncidentsService sparkIncidentsService,
                                 DownstreamService downstreamService) {
        this.applicationService = applicationService;
        this.sparkIncidentsService = sparkIncidentsService;
        this.downstreamService = downstreamService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable String id) {
        return ResponseEntity.ok(applicationService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Application> addApplication(@RequestBody Application application) {
        DynamoDBConfig extSpringData = new DynamoDBConfig();
        extSpringData.dynamoDBMapper().save(application);
        return ResponseEntity.ok(applicationService.addApplication(application));
    }

    @GetMapping("/")
    public ResponseEntity<Set<Application>> allApplications() {
        return ResponseEntity.ok(applicationService.findAll());
    }

    @GetMapping("/rest")
    public ResponseEntity<Object> getUsingRestTemplate() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            return ResponseEntity.ok(restTemplate.getForObject(
                    "https://cybertron-int-healthcheck.dev.ce.eu-central-1-aws.npottdc" +
                            ".sky/userstore/liveness_status",
                    Object.class));

        } catch (Exception e) {
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/web")
    public ResponseEntity<Object> getUsingWebClient() {
        try {
            return ResponseEntity.ok(downstreamService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/webDO")
    public ResponseEntity<Object> getUsingWebClientDO() {
        try {
            return ResponseEntity.ok(downstreamService.findAllDO());
        } catch (Exception e) {
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/spark")
    public ResponseEntity<List<SparkIncidentsData>> getSparkData() {
        try {
            return ResponseEntity.ok(sparkIncidentsService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}