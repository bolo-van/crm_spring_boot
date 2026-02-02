package com.tucanoo.crm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DynamoDbTableProperties.Tables.class)
public class DynamoDbTableProperties {

    @ConfigurationProperties(prefix = "app.dynamodb")
    public record Tables(String entityATable, String entityBTable, String entityCTable) {}
}
