package com.tests.condEventListeners;

import static java.lang.Boolean.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("mainConditional")
public class Main {

    @Autowired
    private ConditionalSubscriber subscriber;

    @Autowired
    private Publisher publisher;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.tests.condEventListeners");
        context.refresh();

        Main main = (Main) context.getBean("mainConditional");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < 1000000; i++) {
            int modulo = i % 3;
            if (modulo == 0) {
                main.publisher.publish(new GenericAppEvent<String>("buum", TRUE));
            } else if (modulo == 1) {
                main.publisher.publish(new GenericAppEvent<String>("bam", FALSE));
            } else {
                main.publisher.publish(new GenericAppEvent<String>("bom!", null));
            }
        }

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
