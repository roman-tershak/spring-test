package com.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AppEvent1Subscriber /*implements ApplicationListener<AppEvent1>*/ {

    private final AtomicInteger cou = new AtomicInteger();

//    @Override
//    @Async
    @EventListener(AppEvent1.class)
    public void onApplicationEvent(AppEvent1 event) {
//        System.out.println("Received event - " + event);
        if (cou.incrementAndGet() % 100000 == 0) {
            System.out.println("Received " + cou + " events");
        }
    }
}
