package com.tests.async;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class AppEvent2AsyncSubscriber {

//    private static final AtomicInteger cou = new AtomicInteger();
    protected static final AtomicInteger threadCount = new AtomicInteger();

    @Async
    @EventListener()
    public void onApplicationEvent(AppEvent2 appEvent) {
//        if (cou.incrementAndGet() % 100000 == 0) {
//            System.out.println("Received " + cou.incrementAndGet() + " events");
//        }
        int threadCount = AppEvent2AsyncSubscriber.threadCount.incrementAndGet();
        int index = Main.logInd.getAndIncrement();
        long timestamp = System.currentTimeMillis();

        Main.logs[index][0] = timestamp;
        Main.logs[index][3] = appEvent.getMessage();
        Main.logs[index][4] = threadCount;

        try {
            Thread.sleep(0, 500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AppEvent2AsyncSubscriber.threadCount.decrementAndGet();
    }
}
