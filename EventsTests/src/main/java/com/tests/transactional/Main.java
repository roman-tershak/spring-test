package com.tests.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("mainTransactional")
public class Main {

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private TransactionalListener transactionalListener;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.tests.transactional");
        context.refresh();

        Main main = (Main) context.getBean("mainTransactional");

        main.transactionalService.transMethod1();
    }
}
