package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyService {
    public void doSomething() {
        System.out.println("hello world");
    }
}
