package com.sdc.designpatterns.proxy.sell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description: 柜台A
 * CreateTime: 2018/9/25 9:55
 * Author: ShengDecheng
 */

public class GuiTaiA implements InvocationHandler {

    private Object pinPai;

    public GuiTaiA(Object pinPai){
        this.pinPai = pinPai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始，柜台是：" + this.getClass().getSimpleName());
        method.invoke(pinPai, args);
        System.out.println("销售结束");
        return null;
    }
}
