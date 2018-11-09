package com.tests.beans.annotations.aop;

import org.springframework.stereotype.Component;

@Component
public class CompoA implements ICompoA {
    @Override
    public void meth1() {
        System.out.println("inside meth1, this = " + this);
    }
}
