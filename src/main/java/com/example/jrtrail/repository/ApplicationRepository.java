package com.example.jrtrail.repository;

import com.example.jrtrail.model.Application;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ApplicationRepository extends CrudRepository<Application, String> {
}
