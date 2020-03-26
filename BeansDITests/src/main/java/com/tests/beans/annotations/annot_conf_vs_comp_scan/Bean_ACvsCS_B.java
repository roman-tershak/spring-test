package com.tests.beans.annotations.annot_conf_vs_comp_scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean_ACvsCS_B {

    @Autowired
    private Bean_ACvsCS_A beanA;

    public Bean_ACvsCS_A getBeanA() {
        return beanA;
    }
    public void setBeanA(Bean_ACvsCS_A beanA) {
        this.beanA = beanA;
    }

    public void doSomething() {
        System.out.println("property beanA = " + beanA);
    }
}
