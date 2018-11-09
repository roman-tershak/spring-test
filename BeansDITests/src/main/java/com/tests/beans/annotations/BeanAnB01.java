package com.tests.beans.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BeanAnB01 {

    @Autowired
    private IBeanAn01 beanAn01;

    public void doSomething() {
        long start, stop;
        System.out.println("before calling meth1 of " + beanAn01 + ", start = " + (start = System.currentTimeMillis()));
        for (int i = 0; i < 1000000; i++) {
            beanAn01.meth1();
        }
        System.out.println("after calling meth1, stop = " + (stop = System.currentTimeMillis()) + ", time = " + (stop - start));
        System.out.println(BeanAn01.cou);
    }
}
