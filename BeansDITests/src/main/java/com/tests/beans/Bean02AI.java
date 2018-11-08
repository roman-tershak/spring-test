package com.tests.beans;

public class Bean02AI implements IBean01 {
    public Bean02AI() {
        System.out.println("Constructor of  " + this);
    }
    public void doSomething() {
        System.out.println("This is " + this);
    }
}
