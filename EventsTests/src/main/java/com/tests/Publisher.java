package com.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private ApplicationContext ctx;

    public void publish(String msg) {
//        System.out.println("Publishing  event...");
        ctx.publishEvent(new AppEvent1(this, msg));
    }
}
