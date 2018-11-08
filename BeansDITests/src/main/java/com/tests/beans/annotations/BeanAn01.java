package com.tests.beans.annotations;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BeanAn01 implements IBeanAn01 {

    @Transactional
    @Override
    public void meth1() {
        System.out.println("inside meth1, this = " + this);
    }
}
