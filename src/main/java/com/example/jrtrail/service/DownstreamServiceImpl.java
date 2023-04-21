package com.example.jrtrail.service;

import com.example.jrtrail.model.downstream.LivenessNestedStatus;
import com.example.jrtrail.model.downstream.LivenessStatus;
import com.example.jrtrail.repository.DownstreamRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DownstreamServiceImpl implements DownstreamService {

    private final DownstreamRepository downstreamRepository;

    public DownstreamServiceImpl(DownstreamRepository downstreamRepository) {
        this.downstreamRepository = downstreamRepository;
    }

    @Override
    public LivenessStatus findAll() {
        WebClient webClient =
                WebClient.create("https://cybertron-int-healthcheck.dev.ce.eu-central-1-aws.npottdc.sky/userstore");
        return downstreamRepository.findAll(webClient);
    }

    @Override
    public LivenessNestedStatus findAllDO() {
        WebClient webClient =
                WebClient.create("https://cybertron-int-healthcheck.dev.ce.eu-central-1-aws.npottdc.sky/sessions");
        return downstreamRepository.findAllDO(webClient);
    }
}
