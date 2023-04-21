package com.example.jrtrail.model.downstream;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@DynamoDBDocument
@ToString
public class LivenessStatusNew {
    @DynamoDBAttribute(attributeName = "module_name")
    private String moduleName;
    @DynamoDBAttribute(attributeName = "module_availability")
    private String moduleAvailability;

    @DynamoDBHashKey(attributeName = "downstream_service_name")
    private String downstreamServiceName;
}
