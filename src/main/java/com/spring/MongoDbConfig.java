package com.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "mongo")
@Getter
@Setter
@ToString
public class MongoDbConfig {

    private String username;
    @ToString.Exclude
    private String secret;
    private String url;
    private String database;

}
