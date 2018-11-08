package com.tests.spring;

import com.tests.spring.component.Compo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static Application application;

    @Autowired
    private Compo1 compo1;

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

        application = new Application();
        application.compo1.sayHi();
    }
}
