package com.example.jrtrail.repository;

import com.example.jrtrail.model.downstream.Downstream;
import com.example.jrtrail.model.downstream.DownstreamObjectObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Repository
public class DownstreamRepository {

    public Downstream findAll(WebClient webClient) {
        return Objects
                .requireNonNull(webClient.get()
                                        .uri("/liveness_status")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .toEntity(Downstream.class).block()
                               ).getBody();

    }

    public DownstreamObjectObject findAllDO(WebClient webClient) {
        return Objects
                .requireNonNull(webClient.get()
                                        .uri("/liveness_status")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .toEntity(DownstreamObjectObject.class).block()
                               ).getBody();

    }
}
