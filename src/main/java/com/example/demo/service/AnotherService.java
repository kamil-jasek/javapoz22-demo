package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AnotherService {

    private MyService myServiceOne;
    private MyService myServiceTwo;

    public AnotherService(MyService myServiceOne, MyService myServiceTwo) {
        this.myServiceOne = myServiceOne;
        this.myServiceTwo = myServiceTwo;
    }
}
