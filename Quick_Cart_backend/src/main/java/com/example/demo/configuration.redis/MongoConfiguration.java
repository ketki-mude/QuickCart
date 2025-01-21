package com.example.demo.configuration.redis;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.repository.mongo") // Scan only MongoDB repositories
public class MongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri); // Create a MongoClient instance
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    private String getDatabaseName() {
        // Extract database name from the URI (e.g., "my_database" from the connection string)
        return mongoUri.split("/")[3].split("\\?")[0];
    }
}