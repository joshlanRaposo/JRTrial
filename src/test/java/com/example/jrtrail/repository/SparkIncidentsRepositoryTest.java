package com.example.jrtrail.repository;

import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.service.SparkIncidentsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SparkIncidentsRepositoryTest {

    @Mock
    private SparkIncidentsRepository repository;
    @InjectMocks
    private SparkIncidentsServiceImpl service;

    @Test
    void returnsEmptyListWhenNoDataIsPassed() {
        List<SparkIncidentsData> sparks = Collections.emptyList();
        when(repository.findAll()).thenReturn(sparks);
        assertEquals(Collections.emptyList(), service.findAll());

        verify(repository, times(1)).findAll();
    }
}