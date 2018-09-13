package com.sdc.designpatterns.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import static java.lang.reflect.Array.newInstance;

/**
 * Description:
 * CreateTime: 2018/9/13 11:24
 * Author: ShengDecheng
 */

public class GetArray {

    public static void main(String[] args){
        Class clazz = Shuzu.class;

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取field类型
            Class type = field.getType();
            //判断是否数组
            if (type.isArray()){
                System.out.println("Type is : " + type.getName());
                System.out.println("ComponentType is : " + type.getComponentType());
            }
        }

        System.out.println();

        int[][] arr = (int[][]) newInstance(int.class, 2, 3);
        arr[0][1] = 12;
        System.out.println(arr[0][1]);

        System.out.println("-------------- 通过反射操作数组 -------------------");

        try {
            Shuzu shuzu = (Shuzu) clazz.newInstance();

            Field array1 = clazz.getDeclaredField("array");
            array1.setAccessible(true);

            Object object = Array.newInstance(int.class, 3);
            Array.set(object, 0, 4);
            Array.set(object, 1, 6);
            Array.set(object, 2, 9);

            array1.set(shuzu, object);

            int[] array2 = shuzu.getArray();
            for (int i = 0; i < array2.length; i++) {
                System.out.println("array index: " + i + ", value: " + array2[i]);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
