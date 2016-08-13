package com.vaani.parichay.demo;

import lombok.ToString;

/**
 * Created by kchandra on 13/08/16.
 */
@ToString
public class IsdnAgeCsv {
    private String isdn;
    private String age;

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
