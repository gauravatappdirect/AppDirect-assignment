package com.appdirect.assignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created by gaurav on 24/12/16.
 */
@Configuration
public class Jaxb2Config {

    @Value("${appDirectObject.packagesToScan}")
    private String appDirectObjects;

    @Bean
    Jaxb2Marshaller getMarshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(appDirectObjects);
        return marshaller;
    }
}
