package com.tests.beans.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;

@Scope("prototype")
@Component
public class BeanAn01 implements IBeanAn01 {

    public static int cou = 0;

    @Override
    public void meth1() {
        cou++;
//        System.out.println("inside meth1, this = " + this);
    }
}
