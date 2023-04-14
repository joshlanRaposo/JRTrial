package com.example.jrtrail.config;

import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.example.jrtrail.model.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Util implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("Running Table Check");
        DynamoDBConfig config = new DynamoDBConfig();
        CreateTableRequest createTableRequest = config.dynamoDBMapper().generateCreateTableRequest(Application.class)
                .withProvisionedThroughput(new ProvisionedThroughput(1l, 1l));
        TableUtils.createTableIfNotExists(config.amazonDynamoDB(), createTableRequest);
    }
}