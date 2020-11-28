package com.example.demo;

import com.example.demo.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    private MyService myServiceOne;
    private MyService myServiceTwo;
    private List<MyService> services;

    public DemoApplication(MyService myServiceOne, MyService myServiceTwo, List<MyService> services) {
        this.myServiceOne = myServiceOne;
        this.myServiceTwo = myServiceTwo;
        this.services = services;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("hello world");
    }
}
