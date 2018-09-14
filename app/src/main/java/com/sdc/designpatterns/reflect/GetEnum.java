package com.sdc.designpatterns.reflect;

import com.sdc.designpatterns.reflect.bean.Meiju;
import com.sdc.designpatterns.reflect.bean.State;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Description:
 * CreateTime: 2018/9/14 17:40
 * Author: ShengDecheng
 */

public class GetEnum {

    public static void main(String[] args){
        Class clazz = State.class;
        //判断是否枚举类型
        if (clazz.isEnum()){
            System.out.println(clazz.getName() + " is Enum");
            // 获取所有的枚举常量
            System.out.println(Arrays.asList(clazz.getEnumConstants()));

            System.out.println();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isEnumConstant()){
                    System.out.println(field.getName() + " is EnumConstant");
                } else {
                    System.out.println(field.getName() + " is not EnumConstant");
                }
            }

            System.out.println();

            Class cMeiju = Meiju.class;
            Meiju meiju = new Meiju();

            try {
                Field field = cMeiju.getDeclaredField("state");
                field.setAccessible(true);
                State state = (State) field.get(meiju);
                System.out.println("state current is " + state);
                field.set(meiju, State.STOPPING);
                System.out.println("state current is " + meiju.getState());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
