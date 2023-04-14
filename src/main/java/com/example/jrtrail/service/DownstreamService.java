package com.example.jrtrail.service;

import com.example.jrtrail.model.downstream.Downstream;
import com.example.jrtrail.model.downstream.DownstreamObjectObject;

public interface DownstreamService {
    Downstream findAll();

    DownstreamObjectObject findAllDO();
}
