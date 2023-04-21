package com.example.jrtrail.repository;

import com.example.jrtrail.model.downstream.LivenessStatusMap;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface LivenessStatusRepository extends CrudRepository<LivenessStatusMap, String> {
}
