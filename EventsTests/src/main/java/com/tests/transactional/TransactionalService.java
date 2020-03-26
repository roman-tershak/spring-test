package com.tests.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionalService {

    @Autowired
    private ApplicationContext ctx;

    @Transactional
    public void transMethod1() {
        ctx.publishEvent(new TransEvent("inside ..."));
        throw new RuntimeException();
    }
}
