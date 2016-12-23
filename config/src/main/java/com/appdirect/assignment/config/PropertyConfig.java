package com.appdirect.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by gaurav on 23/12/16.
 */
@Configuration
public class PropertyConfig {
    static @Bean
    public PropertySourcesPlaceholderConfigurer myPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Configuration
    @Profile({ "dev", "default" })
    @PropertySource("classpath:application.properties")
    public static class Dev {
    }
}
