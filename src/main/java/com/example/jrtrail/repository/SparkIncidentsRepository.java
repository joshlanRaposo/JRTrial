package com.example.jrtrail.repository;

import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.model.sparkincident.SparkIncidentsList;
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
            SparkIncidentsList sparkIncidentsList = mapper.readValue(resourceFile.getFile(),
                                                                     SparkIncidentsList.class);
            return sparkIncidentsList.getResults();

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
