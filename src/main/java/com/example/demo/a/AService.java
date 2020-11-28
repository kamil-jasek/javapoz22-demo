package com.example.demo.a;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class AService {
    private String suffix;

    public AService() {
        this.suffix = "";
    }

    public void doSomething() {
        System.out.println("blabla " + suffix);
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
