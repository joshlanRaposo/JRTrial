package com.example.jrtrail.controller;

import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.service.SparkIncidentsService;
import com.example.jrtrail.service.SparkIncidentsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SparksController {

    private final SparkIncidentsService sparkIncidentsService;

    public SparksController(SparkIncidentsServiceImpl sparkIncidentsService) {
        this.sparkIncidentsService = sparkIncidentsService;
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
