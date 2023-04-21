package com.example.jrtrail.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.jrtrail.repository.ApplicationRepository;
import com.example.jrtrail.repository.LivenessStatusRepository;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DynamoDB client To Communicate with DynamoDB
 */
@Configuration
@EnableDynamoDBRepositories(basePackageClasses = {ApplicationRepository.class, LivenessStatusRepository.class})
public class DynamoDBConfig {

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        AWSCredentialsProvider credentials = new ProfileCredentialsProvider();

//        System.out.println("Creds: " + credentials.getCredentials().getAWSAccessKeyId());
//        System.out.println("Creds: " + credentials.getCredentials().getAWSSecretKey());

        return AmazonDynamoDBClientBuilder.standard().withCredentials(credentials)
                .withEndpointConfiguration(new AwsClientBuilder
                        .EndpointConfiguration("http://localhost:8000", "eu-west-1"))
                .build();

    }

    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDB());
    }
}
