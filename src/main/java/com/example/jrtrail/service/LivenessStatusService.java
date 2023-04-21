package com.example.jrtrail.service;

import com.example.jrtrail.model.downstream.LivenessStatusMap;
import com.example.jrtrail.repository.DownStreamRepositoryNew;
import com.example.jrtrail.repository.LivenessStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class LivenessStatusService {
    private final LivenessStatusRepository repository;
    private final DownStreamRepositoryNew repositoryNew;

    public LivenessStatusService(LivenessStatusRepository repository, DownStreamRepositoryNew repositoryNew) {
        this.repository = repository;
        this.repositoryNew = repositoryNew;
    }

    public Iterable<LivenessStatusMap> findAll() {
        return repository.findAll();
    }

}
