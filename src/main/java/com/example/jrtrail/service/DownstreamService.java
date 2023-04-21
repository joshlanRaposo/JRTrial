package com.example.jrtrail.service;

import com.example.jrtrail.model.downstream.LivenessNestedStatus;
import com.example.jrtrail.model.downstream.LivenessStatus;
import com.example.jrtrail.model.downstream.LivenessStatusMap;

public interface DownstreamService {
    LivenessStatus findAll();

    LivenessNestedStatus findAllDO();

    LivenessStatusMap save();
}
