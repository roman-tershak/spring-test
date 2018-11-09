package com.tests.beans.annotations.spel;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanA {

    private String propStr;

    private Integer propInt;

    public String getPropStr() {
        return propStr;
    }
    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }

    public Integer getPropInt() {
        return propInt;
    }
    public void setPropInt(Integer propInt) {
        this.propInt = propInt;
    }

    public String doMeth() {
        return propInt + ", then " + propStr;
    }

    @PostConstruct
    private void postConstruct() {
        propStr = "String from postConstruct";
        propInt = 7;
    }
}
