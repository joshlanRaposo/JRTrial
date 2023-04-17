package com.example.jrtrail.repository;

import com.example.jrtrail.model.sparkincident.SparkIncidents;
import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class SparkIncidentsRepository {

    @Value("classpath:data.json")
    Resource resourceFile;

    public List<SparkIncidentsData> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SparkIncidents sparkIncidents = mapper.readValue(resourceFile.getFile(),
                                                             SparkIncidents.class);
            return sparkIncidents.getResults();

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
