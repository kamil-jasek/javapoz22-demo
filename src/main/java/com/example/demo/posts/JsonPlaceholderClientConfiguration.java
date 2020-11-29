package com.example.demo.posts;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JsonPlaceholderClientConfiguration {

    @Bean
    public RestTemplate postsRestTemplate(RestTemplateBuilder restTemplateBuilder, PostResponseErrorHandler postResponseErrorHandler) {
        return restTemplateBuilder
                .errorHandler(postResponseErrorHandler)
                .build();
    }

    @Bean
    public RestTemplate usersRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
