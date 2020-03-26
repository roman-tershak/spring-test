package com.tests.async;

import org.springframework.context.ApplicationEvent;

public class AppEvent2 extends ApplicationEvent {
    private final Integer msg;

    public AppEvent2(Object source, Integer msg) {
        super(source);
        this.msg = msg;
    }

    public Integer getMessage() {
        return msg;
    }
}
