package com.example.jrtrail.service;

import com.example.jrtrail.model.application.Application;
import com.example.jrtrail.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Set<Application> findAll() {
        Set<Application> applications = new HashSet<>();
        applicationRepository.findAll().forEach(applications::add);
        return applications;
    }

    @Override
    public Application findById(String id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public void delete(final Application application) {
        applicationRepository.delete(application);
    }
}
