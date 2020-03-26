package com.tests;

import org.springframework.context.ApplicationEvent;

public class AppEvent1 extends ApplicationEvent {
    private final String msg;

    public AppEvent1(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
