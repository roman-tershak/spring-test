package com.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;

@Component
//@EnableAsync
public class Main {

    @Autowired
    private AppEvent1Subscriber event1Subscriber;
    @Autowired
    private AppEvent1SubscriberWithPause event1SubscriberWithPause;

    @Autowired
    private Publisher publisher;
    @Autowired
    private TimeTrackingPublisher timeTrackingPublisher;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        Main main = (Main) context.getBean("main");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 1000000; i++) {
            main.publisher.publish("msg1");
        }
        stopWatch.stop();
        System.out.println("Took " + stopWatch.getTotalTimeMillis());
    }

    public static void main2(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        Main main = (Main) context.getBean("main");
        main.timeTrackingPublisher.publish("msg1");
        main.timeTrackingPublisher.publish("msg2");
        main.timeTrackingPublisher.publish("msg3");
    }
}
