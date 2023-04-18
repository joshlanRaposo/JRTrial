package com.example.jrtrail.service;

import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.model.sparkincident.SparkIncidentsList;
import com.example.jrtrail.repository.SparkIncidentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SparkIncidentsListServiceImplTest {

    @Mock
    private SparkIncidentsRepository repository;
    private SparkIncidentsList array;
    @InjectMocks
    private SparkIncidentsServiceImpl service;

    @BeforeEach
    void setUp() {
        List<SparkIncidentsData> sparks = new ArrayList<>();
        array = new SparkIncidentsList();
        SparkIncidentsData incident = new SparkIncidentsData("123123", "test", "test", "test", "test", "test");

        sparks.add(incident);

        array.setResults(sparks);
    }

    @Test
    void getIncidentsTest() {
        when(repository.findAll()).thenReturn(array.getResults());
        assertEquals(1, service.findAll().size());
        assertFalse(service.findAll().isEmpty());
        assertNotNull(service.findAll());
    }
}