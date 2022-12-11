package io.fantasy.bank.backend.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfigModule {

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}