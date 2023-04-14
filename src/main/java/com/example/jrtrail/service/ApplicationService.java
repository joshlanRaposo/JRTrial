package com.example.jrtrail.service;

import com.example.jrtrail.model.application.Application;

import java.util.Set;

public interface ApplicationService {
    Application findById(String id);

    Application addApplication(final Application application);

    Set<Application> findAll();

    void deleteById(String id);

    void delete(final Application application);

}
