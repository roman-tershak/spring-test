package com.tests;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AppEvent1SubscriberWithPause /*implements ApplicationListener<AppEvent1>*/ {

    private final AtomicInteger cou = new AtomicInteger();

//    @Override
//    @EventListener(AppEvent1.class)
    public void onApplicationEvent(AppEvent1 event) {
        System.out.println("Received event - " + event.getMessage());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Resumed");
    }
}
