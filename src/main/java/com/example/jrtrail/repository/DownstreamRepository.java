package com.example.jrtrail.repository;

import com.example.jrtrail.model.downstream.LivenessNestedStatus;
import com.example.jrtrail.model.downstream.LivenessStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Repository
public class DownstreamRepository {

    public LivenessStatus getStatus(WebClient webClient) {
        LivenessStatus livenessStatus = Objects
                .requireNonNull(webClient.get()
                                        .uri("/liveness_status")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .toEntity(LivenessStatus.class).block()
                               ).getBody();

        return livenessStatus;
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

/*    public LivenessStatus getLivenessStatusFromEndpoint() {
        WebClient webClient =
                WebClient.create("https://cybertron-int-healthcheck.dev.ce.eu-central-1-aws.npottdc.sky/userstore");

        LivenessStatus livenessStatus = Objects.requireNonNull(webClient.get()
                                                                       .uri("/liveness_status")
                                                                       .accept(MediaType.APPLICATION_JSON)
                                                                       .retrieve()
                                                                       .toEntity(LivenessStatus.class).block()
                                                              ).getBody();

        Map<String, LivenessStatusNew> map = new HashMap<>();

        for (Map.Entry<String, String> i : livenessStatus.getDownstreamService().entrySet()) {
            System.out.println("Key -> " + i.getKey() + " Value -> " + i.getValue());
        }


        return Objects
                .requireNonNull(webClient.get()
                                        .uri("/liveness_status")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .toEntity(LivenessStatus.class).block()
                               ).getBody();
    }*/
}
