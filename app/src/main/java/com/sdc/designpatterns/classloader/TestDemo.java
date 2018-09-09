package com.sdc.designpatterns.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: 测试自定义ClassLoader，加载指定路径下的class文件
 * CreateTime: 2018/8/25 11:13
 * Author: ShengDecheng
 */

public class TestDemo {

    public static void main(String[] args){
        //创建自定义classloader对象。
        MyClassLoader classLoader = new MyClassLoader("E:/sdc");
        System.out.println("classLoader:"+classLoader.toString()); //com.sdc.designpatterns.classloader.MyClassLoader@4aa298b7
        System.out.println("classLoader:"+classLoader.getParent().toString()); //sun.misc.Launcher$AppClassLoader@33909752
        System.out.println("classLoader:"+classLoader.getParent().getParent().toString()); //sun.misc.Launcher$ExtClassLoader@7d4991ad
        try {
            //加载class文件
            Class cls = classLoader.loadClass("com.sdc.designpatterns.classloader.Person");
            if (cls != null){
                Object obj = cls.newInstance();
                Method method = cls.getDeclaredMethod("say", null);
                //通过反射调用Person类的say方法
                method.invoke(obj, null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
