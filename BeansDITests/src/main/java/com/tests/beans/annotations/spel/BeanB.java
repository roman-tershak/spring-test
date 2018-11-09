package com.tests.beans.annotations.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    @Value("#{beanA.propStr}")
    private String propStr;

    @Value("#{beanA.propInt}")
    private Integer propInt;

    @Value("#{beanA.doMeth()}")
    private String propStr2;

    public void doSomething() {
        System.out.println("property propStr = " + propStr + ", property propInt = " + propInt);

        System.out.println("callig method... " + propStr2);
    }
}
