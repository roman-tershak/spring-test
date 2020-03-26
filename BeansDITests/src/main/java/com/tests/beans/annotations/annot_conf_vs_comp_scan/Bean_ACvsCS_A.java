package com.tests.beans.annotations.annot_conf_vs_comp_scan;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean_ACvsCS_A {
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
        System.out.println("inside " + this + "#doMeth() method");
        return propInt + ", then " + propStr;
    }

    @PostConstruct
    private void postConstruct() {
        propStr = "String from postConstruct";
        propInt = 7;
        System.out.println("from A postConstruct");
    }
}
