package com.example.jrtrail.repository;

import com.example.jrtrail.model.downstream.LivenessNestedStatus;
import com.example.jrtrail.model.downstream.LivenessStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Repository
public class DownstreamRepository {

    public LivenessStatus findAll(WebClient webClient) {
        return Objects
                .requireNonNull(webClient.get()
                                        .uri("/liveness_status")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .toEntity(LivenessStatus.class).block()
                               ).getBody();

    }

    public LivenessNestedStatus findAllDO(WebClient webClient) {
        return Objects
                .requireNonNull(webClient.get()
                                        .uri("/liveness_status")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .toEntity(LivenessNestedStatus.class).block()
                               ).getBody();

    }
}
