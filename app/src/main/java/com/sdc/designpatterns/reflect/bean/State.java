package com.sdc.designpatterns.reflect.bean;

/**
 * Description:
 * CreateTime: 2018/9/14 17:44
 * Author: ShengDecheng
 */

public enum State {
    IDLE,
    DRIVING,
    STOPPING,

    test();

    int test1() {
        return 0;
    }
}
