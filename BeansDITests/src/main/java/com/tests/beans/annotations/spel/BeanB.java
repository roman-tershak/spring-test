package com.tests.beans.annotations.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanB {

    @Value("#{beanA.propStr.length() + 1000000}")
    private String propStr;

    @Value("#{beanA.propInt + 18}")
    private Integer propInt;

    @Value("#{beanA.doMeth()}")
    private String propStr2;

    @Value("#{{1,2,3,4}}")
    private List<Integer> listOfIntegers;

    @Value("#{{{1,2,3},{1,2},{1,2,3,4}}}")
    private List<List<String>> listListString;

    public void doSomething() {
        System.out.println("property propStr = " + propStr + ", property propInt = " + propInt);
        System.out.println("listOfIntegers = " + listOfIntegers + ", " + listOfIntegers.size());
        System.out.println("listListString = " + listListString + ", get(1, 1) = " + listListString.get(1).get(1).getClass());
        System.out.println("callig method... " + propStr2);
    }
}
