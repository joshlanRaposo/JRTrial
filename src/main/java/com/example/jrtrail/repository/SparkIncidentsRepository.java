package com.example.jrtrail.repository;

import com.example.jrtrail.model.sparkincident.SparkIncidents;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class SparkIncidentsRepository {

    public SparkIncidents findAll() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("src/main/resources/data.json"), SparkIncidents.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
