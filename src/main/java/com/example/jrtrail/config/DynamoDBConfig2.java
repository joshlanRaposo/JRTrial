package com.example.jrtrail.config;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

//@Configuration
public class DynamoDBConfig2 {

    //    @Bean
    public DynamoDbClient getDynamoDBClient() {
        AwsCredentialsProvider credentials = DefaultCredentialsProvider.builder().build();

        System.out.println(credentials);

        return DynamoDbClient.builder()
                .region(Region.EU_WEST_1)
                .credentialsProvider(credentials)
                .endpointOverride(URI.create("http://localhost:8000"))
                .build();

    }

    //    @Bean
    public DynamoDbEnhancedClient getDynamoDbEnhancedClient() {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(getDynamoDBClient())
                .build();
    }
}
