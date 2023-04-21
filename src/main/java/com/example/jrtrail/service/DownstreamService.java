package com.example.jrtrail.service;

import com.example.jrtrail.model.downstream.LivenessNestedStatus;
import com.example.jrtrail.model.downstream.LivenessStatus;

public interface DownstreamService {
    LivenessStatus findAll();

    LivenessNestedStatus findAllDO();
}
