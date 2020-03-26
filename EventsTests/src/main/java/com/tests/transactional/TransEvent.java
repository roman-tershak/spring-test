package com.tests.transactional;

public class TransEvent {

    private Object source;

    public TransEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
