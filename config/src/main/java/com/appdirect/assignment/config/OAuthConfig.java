package com.appdirect.assignment.config;

import org.scribe.builder.ServiceBuilder;
import org.scribe.components.OAuth10APIProvider;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by gaurav on 24/12/16.
 */
@Configuration
public class OAuthConfig {

    @Value("${appDirect.OAuthKey}")
    private String oAuthKey;

    @Value("${appDirect.OAuthSecret}")
    private String oAuthSecret;

    @Primary
    @Bean
    public OAuthService getOAuthService(){
        OAuthService service = new ServiceBuilder()
                .provider(OAuth10APIProvider.class)
                .apiKey(oAuthKey)
                .apiSecret(oAuthSecret)
                .build();
        return service;
    }

    @Bean
    public Token getToken(){
        return new Token("", "");
    }
}
