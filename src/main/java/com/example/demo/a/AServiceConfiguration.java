package com.example.demo.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AServiceConfiguration {

    @Bean
    @Profile("prod")
    public AService aServiceWithSuffix() {
        AService aService = new AService();
        aService.setSuffix("Lorem ipsum");
        return aService;
    }

    @Bean
    public AService aServiceWithSuffixFromProperties(@Value("${aService.suffix}") String suffix) {
        AService aService = new AService();
        aService.setSuffix(suffix);
        return aService;
    }
}
