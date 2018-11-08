package com.tests.beans;

public class Bean03AI implements IBean01 {
    public Bean03AI() {
        System.out.println("Constructor of  " + this);
    }
    public void doSomething() {
        System.out.println("This is " + this);
    }
}
