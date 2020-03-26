package com.tests.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("publisherAsync")
public class Publisher {

    @Autowired
    private ApplicationContext ctx;

    public void publish(int msg) {
        int index = Main.logInd.getAndIncrement();
        long timestamp = System.currentTimeMillis();
        int threadCount = AppEvent2AsyncSubscriber.threadCount.get();

        long start = System.nanoTime();
        ctx.publishEvent(new AppEvent2(this, msg));
        long stop = System.nanoTime();

        Main.logs[index][0] = timestamp;
        Main.logs[index][1] = msg;
        Main.logs[index][2] = stop - start;
        Main.logs[index][4] = threadCount;
    }
}
