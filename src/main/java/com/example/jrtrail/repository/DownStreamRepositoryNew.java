package com.example.jrtrail.repository;

import com.example.jrtrail.model.downstream.LivenessNestedStatus;
import com.example.jrtrail.model.downstream.LivenessStatus;
import com.example.jrtrail.model.downstream.LivenessStatusMap;
import com.example.jrtrail.model.downstream.LivenessStatusNew;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Objects;

@Repository
public class DownStreamRepositoryNew {

    public LivenessStatus getStatus(WebClient webClient) {

        return Objects
                .requireNonNull(webClient.get()
                                        .uri("/liveness_status")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .retrieve()
                                        .toEntity(LivenessStatus.class).block()
                               ).getBody();
    }

    public LivenessStatusMap saveStatus() {
        LivenessStatusMap map = new LivenessStatusMap();
        WebClient webClient =
                WebClient.create("https://cybertron-int-healthcheck.dev.ce.eu-central-1-aws.npottdc.sky/userstore");
        LivenessStatus livenessStatus = getStatus(webClient);

        LivenessStatusNew s = new LivenessStatusNew();

        for (Map.Entry<String, String> i : Objects.requireNonNull(livenessStatus).getDownstreamService().entrySet()) {
            s.setModuleName("userstore");
            s.setDownstreamServiceName(i.getKey());
            s.setModuleAvailability(i.getValue());

        }
        map.getModules().add(s);
        return map;
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

