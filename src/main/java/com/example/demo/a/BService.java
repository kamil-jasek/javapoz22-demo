package com.example.demo.a;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class BService {
    private AService aService;

    public BService(AService blabla) {
        this.aService = blabla;

        this.aService.doSomething();
    }
}
