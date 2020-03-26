package com.tests.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@EnableAsync
@Component("mainAsync")
public class Main {

    @Autowired
    private Publisher publisher;

    @Autowired
    private AppEvent2AsyncSubscriber subscriber;

    protected static int MSG_NUM = 100000;
    protected static volatile long[][] logs = new long[MSG_NUM * 2][5];
    protected static final AtomicInteger logInd = new AtomicInteger();

    @Bean("threadPoolTaskExecutor")
    protected Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(256);
        System.out.println("executor.isDaemon() = " + executor.isDaemon());
        executor.setDaemon(true);
        return executor;
    }

    public static void main(String[] args) throws IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.tests.async");
        context.refresh();

        Main main = (Main) context.getBean("mainAsync");

        long start = System.currentTimeMillis();
        for (int i = 0; i < MSG_NUM; i++) {
            main.publisher.publish(i);
        }
//        System.out.println("Finished publishing");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("logs.tsv"));
        for (int i = 0; i < logs.length; i++) {
            String ln = (logs[i][0] - start) + "\t" +
                    logs[i][1] + "\t" +
                    logs[i][2] + "\t" +
                    logs[i][3] + "\t" +
                    logs[i][4];
            writer.write(ln);
            writer.newLine();
        }
        writer.close();

        context.stop();

        System.out.println("Finished");
    }
}
