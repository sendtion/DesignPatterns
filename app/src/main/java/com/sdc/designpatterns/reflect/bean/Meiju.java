package com.sdc.designpatterns.reflect.bean;

/**
 * Description:
 * CreateTime: 2018/9/14 17:45
 * Author: ShengDecheng
 */

public class Meiju {

    private State state = State.DRIVING;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
