package com.sdc.designpatterns.reflect.bean;

/**
 * Description:
 * CreateTime: 2018/9/1 16:48
 * Author: ShengDecheng
 */

public class Person {

    String username;

    private int age;

    public String address;

    public Person(){
        super();
    }

    public String getUserName(){
        return username;
    }
}
