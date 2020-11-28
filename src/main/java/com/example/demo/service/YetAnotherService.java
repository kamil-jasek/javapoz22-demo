package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class YetAnotherService {
    private MyService a;

    public YetAnotherService(MyService a) {
        this.a = a;
    }

    public void somthing(){
        a.doSomething();
    }
}
