package com.sdc.designpatterns.reflect;

import java.lang.reflect.Modifier;

/**
 * Description: 获取类de修饰符
 * CreateTime: 2018/9/6 16:45
 * Author: ShengDecheng
 */

public class GetModifier {
    public static void main(String[] args) {
        System.out.println("ModifierTest value:" + ModifierTest.class.getModifiers()); //1025
        System.out.println("ModifierTest :" + Modifier.toString(ModifierTest.class.getModifiers()));   //public abstract

    }
}
