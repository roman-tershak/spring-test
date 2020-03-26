package com.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class TimeTrackingPublisher {

    @Autowired
    private ApplicationContext ctx;

    public void publish(String msg) {
//        System.out.println("Publishing  event...");
        System.out.println("Publishing event " + msg);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ctx.publishEvent(new AppEvent1(this, msg));
        stopWatch.stop();
        System.out.println("Publishing took " + stopWatch.getTotalTimeMillis());
    }
}
