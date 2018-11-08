package com.tests.beans;

public class Bean01A {

    private IBean01 iBean01;

    public String saySomething() {
        return "something";
    }

    public IBean01 getiBean01() {
        return iBean01;
    }

    public void setiBean01(IBean01 iBean01) {
        this.iBean01 = iBean01;
    }
}
