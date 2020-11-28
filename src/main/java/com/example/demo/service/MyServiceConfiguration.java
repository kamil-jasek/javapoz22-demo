package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyServiceConfiguration {

    @Bean
    @Profile("prod")
    public MyService myServiceOne() {
        MyService myService = new MyService();
        System.out.println("creating myServiceOne");
        // modyfikacja
        // myService.addHeader(true);
        return myService;
    }

    @Bean
    public MyService myServiceTwo() {
        MyService myService = new MyService();
        System.out.println("creating myServiceTwo");

        // modyfikacja
        // myService.addHeader(false);
        return myService;
    }
}
