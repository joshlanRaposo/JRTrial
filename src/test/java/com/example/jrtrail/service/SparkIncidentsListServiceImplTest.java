package com.example.jrtrail.service;

import com.example.jrtrail.model.sparkincident.AssignmentGroup;
import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.repository.SparkIncidentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SparkIncidentsListServiceImplTest {

    @Mock
    private SparkIncidentsRepository repository;
    @InjectMocks
    private SparkIncidentsServiceImpl service;

    private List<SparkIncidentsData> sparks;

    @BeforeEach
    void setUp() {

        AssignmentGroup group = new AssignmentGroup("a", "b");

        SparkIncidentsData incident = new SparkIncidentsData("123123", "test", group, "test", "test", "test", "test");

        sparks = List.of(incident);
    }

    @Test
    void getIncidentsTest() {
        when(repository.findAll()).thenReturn(sparks);
        assertEquals(1, service.findAll().size());

        verify(repository, times(1)).findAll();
    }

    @Test
    void getIncidentsNotNull() {
        when(repository.findAll()).thenReturn(sparks);
        assertNotNull(service.findAll());

        verify(repository, times(1)).findAll();
    }

    @Test
    void getIncidentsIsNotEmpty() {
        when(repository.findAll()).thenReturn(sparks);
        assertFalse(service.findAll().isEmpty());
        verify(repository, times(1)).findAll();

    }
}