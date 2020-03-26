package com.tests.condEventListeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("publisherConditional")
public class Publisher {

    @Autowired
    private ApplicationContext ctx;

    public void publish(GenericAppEvent event) {
        ctx.publishEvent(event);
    }
}
