package com.tests;

import com.tests.beans.Bean01A;
import com.tests.beans.IBean01;
import com.tests.beans.Prototype01A;
import com.tests.beans.Singletone01;
import com.tests.beans.annotations.BeanAnB01;
import com.tests.beans.annotations.annot_conf_vs_comp_scan.Bean_ACvsCS_B;
import com.tests.beans.annotations.aop.CompoB;
import com.tests.beans.annotations.spel.BeanB;
import com.tests.beans.init.BeanPrototype;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MainClassDITEst01 {

    public static void main1(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        Bean01A bean01A = context.getBean("bean01A", Bean01A.class);
        System.out.println(bean01A.saySomething());
    }

    public static void main2(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        Prototype01A prototype01a1 = context.getBean("prototype01a", Prototype01A.class);
        Prototype01A prototype01a2 = context.getBean("prototype01a", Prototype01A.class);

        prototype01a1.doSomething();
        prototype01a2.doSomething();

        Singletone01 singletone011 = context.getBean("singletone01", Singletone01.class);
        Singletone01 singletone012 = context.getBean("singletone01", Singletone01.class);

        singletone011.doSomething();
        singletone012.doSomething();
    }

    public static void main3(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        IBean01 singletonInterface = context.getBean("singletonInterface01", IBean01.class);
        singletonInterface.doSomething();
        singletonInterface = context.getBean("singletonInterface01", IBean01.class);
        singletonInterface.doSomething();
        singletonInterface = context.getBean("singletonInterface02", IBean01.class);
        singletonInterface.doSomething();
        singletonInterface = context.getBean("singletonInterface02", IBean01.class);
        singletonInterface.doSomething();
        singletonInterface = context.getBean("singletonInterface03", IBean01.class);
        singletonInterface.doSomething();
        singletonInterface = context.getBean("singletonInterface03", IBean01.class);
        singletonInterface.doSomething();
    }

    public static void main4(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        BeanAnB01 beanAnB01 = context.getBean("beanAnB01", BeanAnB01.class);
        beanAnB01.doSomething();
    }

    public static void main5(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

        CompoB compoB = context.getBean("compoB", CompoB.class);
        compoB.doSomething();
    }

    public static void main6(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context-spel.xml");

        BeanB beanB = context.getBean(BeanB.class);
        beanB.doSomething();
    }

    public static void main7(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context-annot-conf-vs-comp-scan.xml");

        Bean_ACvsCS_B beanB = context.getBean(Bean_ACvsCS_B.class);
        beanB.doSomething();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context-creation-test.xml");

        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

        BeanPrototype beanProto;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 1000000; i++) {
            beanProto = context.getBean("beanProto", BeanPrototype.class);
        }
        stopWatch.stop();
        System.out.println("...it took " + stopWatch.getTotalTimeMillis());
    }
}
