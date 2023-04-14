package com.example.jrtrail.service;

import com.example.jrtrail.model.sparkincident.SparkIncidents;
import com.example.jrtrail.repository.SparkIncidentsRepository;
import org.springframework.stereotype.Service;

@Service
public class SparkIncidentsServiceImpl implements SparkIncidentsService {

    private final SparkIncidentsRepository sparkIncidentsRepository;

    public SparkIncidentsServiceImpl(SparkIncidentsRepository sparkIncidentsRepository) {
        this.sparkIncidentsRepository = sparkIncidentsRepository;
    }

    @Override
    public SparkIncidents findAll() {
        return sparkIncidentsRepository.findAll();
    }
}
