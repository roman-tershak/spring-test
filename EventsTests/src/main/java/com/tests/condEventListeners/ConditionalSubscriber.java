package com.tests.condEventListeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ConditionalSubscriber {

    private static AtomicInteger successCounter = new AtomicInteger();
    private static AtomicInteger failCounter = new AtomicInteger();

    @EventListener(condition = "#event.success")
    public void handleTrue(GenericAppEvent<Boolean> event) {
        if (successCounter.getAndIncrement() % 10000 == 0) {
            System.out.println(event.getEvent() + ", " + event.getSuccess());
        }
    }

    @EventListener(condition = "{!#event.success}")
    public void handleFalse(GenericAppEvent<Boolean> event) {
        if (failCounter.getAndIncrement() % 10000 == 0) {
            System.out.println(event.getEvent() + ", " + event.getSuccess());
        }
    }
}
