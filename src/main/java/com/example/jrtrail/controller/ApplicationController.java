package com.example.jrtrail.controller;

import com.example.jrtrail.config.DynamoDBConfig;
import com.example.jrtrail.model.Application;
import com.example.jrtrail.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Controller
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
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
}