package com.example.jrtrail.controller;

import com.example.jrtrail.model.sparkincident.AssignmentGroup;
import com.example.jrtrail.model.sparkincident.SparkIncidentsData;
import com.example.jrtrail.service.SparkIncidentsServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SparksController.class)
class SparksControllerTest {

    @MockBean
    SparkIncidentsServiceImpl service;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getSparkData() throws Exception {
        AssignmentGroup group = new AssignmentGroup("a", "b");
        SparkIncidentsData incident = new SparkIncidentsData("123123", "test", group, "test", "test", "test", "test");
        List<SparkIncidentsData> sparks = List.of(incident);

        when(service.findAll()).thenReturn(sparks);

        mockMvc.perform(get("/spark"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].number", Matchers.is("123123")));

        verify(service, times(1)).findAll();
    }
}