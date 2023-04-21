package com.example.jrtrail.service;

import com.example.jrtrail.model.downstream.LivenessNestedStatus;
import com.example.jrtrail.model.downstream.LivenessStatus;
import com.example.jrtrail.model.downstream.LivenessStatusMap;
import com.example.jrtrail.repository.DownStreamRepositoryNew;
import com.example.jrtrail.repository.DownstreamRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DownstreamServiceImpl implements DownstreamService {

    private final DownstreamRepository downstreamRepository;
    private final DownStreamRepositoryNew downstreamRepository2;


    public DownstreamServiceImpl(DownstreamRepository downstreamRepository,
                                 DownStreamRepositoryNew downstreamRepository2) {
        this.downstreamRepository = downstreamRepository;
        this.downstreamRepository2 = downstreamRepository2;
    }

    @Override
    public LivenessStatus findAll() {
        WebClient webClient =
                WebClient.create("https://cybertron-int-healthcheck.dev.ce.eu-central-1-aws.npottdc.sky/userstore");
        return downstreamRepository.getStatus(webClient);
    }

    @Override
    public LivenessNestedStatus findAllDO() {
        WebClient webClient =
                WebClient.create("https://cybertron-int-healthcheck.dev.ce.eu-central-1-aws.npottdc.sky/sessions");
        return downstreamRepository.findAllDO(webClient);
    }

    @Override
    public LivenessStatusMap save() {
        return downstreamRepository2.saveStatus();
    }
}
