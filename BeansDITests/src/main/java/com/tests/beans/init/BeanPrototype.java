package com.tests.beans.init;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.atomic.AtomicInteger;

@Component("beanProto")
@Scope(SCOPE_PROTOTYPE)
public class BeanPrototype /*implements InitializingBean */{

    private static AtomicInteger cou = new AtomicInteger();
    private static AtomicInteger cou2 = new AtomicInteger();

    private String propS;
    private Integer propI;

    public String getPropS() {
        return propS;
    }

    public void setPropS(String propS) {
        this.propS = propS;
    }

    public Integer getPropI() {
        return propI;
    }

    public void setPropI(Integer propI) {
        this.propI = propI;
    }

    @PostConstruct
    protected void init() {
        if (cou.incrementAndGet() % 100000 == 0) {
            System.out.println(cou);
        }
    }

    @PreDestroy
    protected void destroy() {
        if (cou2.incrementAndGet() % 100000 == 0) {
            System.out.println("from destroy - " + cou2);
        }
    }

//    @Override
    public void afterPropertiesSet() throws Exception {
//        if (cou.incrementAndGet() % 100000 == 0) {
//            System.out.println(cou);
//        }
    }
}
