package com.tests.beans.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanAnB01 {

    @Autowired
    private IBeanAn01 beanAn01;

    public void doSomething() {
        System.out.println("before calling meth1 of " + beanAn01);
        beanAn01.meth1();
        System.out.println("after calling meth1");
    }
}
