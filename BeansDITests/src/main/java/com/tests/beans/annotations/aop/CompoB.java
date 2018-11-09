package com.tests.beans.annotations.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompoB {

    @Autowired
    private ICompoA compoA;

    public void doSomething() {
        System.out.println("before meth1");
        compoA.meth1();
        System.out.println("after meth1");
    }
}
