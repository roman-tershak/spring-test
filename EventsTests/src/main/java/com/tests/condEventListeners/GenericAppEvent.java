package com.tests.condEventListeners;

import org.springframework.context.ApplicationEvent;

public class GenericAppEvent<T> extends ApplicationEvent {

    private T event;
    private Boolean success;

    public GenericAppEvent(T event, Boolean success) {
        super(event);
        this.event = event;
        this.success = success;
    }

    public T getEvent() {
        return event;
    }

    public void setEvent(T event) {
        this.event = event;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
