package com.example.jrtrail.service;

import com.example.jrtrail.model.sparkincident.SparkIncidentsData;

import java.util.List;

public interface SparkIncidentsService {
    List<SparkIncidentsData> findAll();
}
