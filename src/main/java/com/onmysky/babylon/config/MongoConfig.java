package com.onmysky.babylon.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by mark on 15/11/11.
 */
@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.host}")
    private String mongoUrl;
    private static int port = 27017;

    @Override
    protected String getDatabaseName() {
        return null;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoUrl, port);
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.onmysky.babylon";
    }

    @Bean
    public MongoTemplate testDB() throws Exception {
        return new MongoTemplate(mongo(), "test");
    }
}
