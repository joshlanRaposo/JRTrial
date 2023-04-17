package com.example.jrtrail.service;

import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.repository.SparkIncidentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparkIncidentsServiceImpl implements SparkIncidentsService {

    private final SparkIncidentsRepository sparkIncidentsRepository;

    public SparkIncidentsServiceImpl(SparkIncidentsRepository sparkIncidentsRepository) {
        this.sparkIncidentsRepository = sparkIncidentsRepository;
    }

    @Override
    public List<SparkIncidentsData> findAll() {
        return sparkIncidentsRepository.findAll();
    }
}
