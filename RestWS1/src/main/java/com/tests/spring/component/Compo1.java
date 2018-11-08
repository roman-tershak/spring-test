package com.tests.spring.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Compo1 {

    public void sayHi() {
        System.out.println("Sya 'Hi'.");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("\npostConstruct\n");
    }
}
