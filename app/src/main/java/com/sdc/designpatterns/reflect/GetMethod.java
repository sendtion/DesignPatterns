package com.sdc.designpatterns.reflect;

import com.sdc.designpatterns.reflect.bean.Women;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: 获取方法
 * CreateTime: 2018/9/6 16:57
 * Author: ShengDecheng
 */

public class GetMethod {
    public static void main(String[] args) {

        //getMyFields();

        //getMyMethods();

        getMyConstructors();

    }

    private static void getMyMethods() {
        Class clazz = Women.class;

//        System.out.println("------------------ 通过反射获取指定方法 ---------------------");
//
//        try {
//            //获取自身和父类的public方法
//            Method method = clazz.getMethod("wait");
//            System.out.println("wait method:" + method.toString());
//            method = clazz.getMethod("eat");
//            System.out.println("eat method:" + method.toString());
//            method = clazz.getMethod("getUserName");
//            System.out.println("getUserName method:" + method.toString());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//
//        try {
//            //获取自身的所有方法
//            Method method = clazz.getDeclaredMethod("walk");
//            System.out.println("walk method:" + method.toString());
//            method = clazz.getDeclaredMethod("sing");
//            System.out.println("sing method:" + method.toString());
//            method = clazz.getDeclaredMethod("eat", String.class); //第二个是参数，可以有多个
//            System.out.println("eat method:" + method.toString());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        System.out.println("------------------ 通过反射获取所有方法 ---------------------");
//
//        //获取自身和父类的所有public方法
//        Method[] methods = clazz.getMethods();
//
//        for (Method method : methods) {
//            System.out.println("getMethods: " + method.toString());
//            System.out.println("getMethods: " + method.getName());
//            System.out.println("getMethods: " + method.getReturnType());  // 获取返回值类型
//            System.out.println("getMethods: " + method.getGenericReturnType()); // 获取返回值类型包括泛型
//            System.out.println("getMethods: " + method.getParameters());
//            System.out.println("getMethods: " + method.getParameterTypes()); // 获取所有的参数类型
//            System.out.println("getMethods: " + method.getGenericParameterTypes()); // 获取所有的参数类型，包括泛型
//            System.out.println("getMethods: " + Modifier.toString(method.getModifiers()));
//            System.out.println("*************************************");
//        }
//
//        System.out.println();
//
//        //获取自身的所有方法
//        methods = clazz.getDeclaredMethods();
//
//        for (Method method : methods) {
//            System.out.println("getDeclaredMethods: " + method.toString());
//            System.out.println("getDeclaredMethods: " + method.getName());
//            System.out.println("getDeclaredMethods: " + method.getReturnType());
//            System.out.println("getDeclaredMethods: " + method.getGenericReturnType());
//            System.out.println("getDeclaredMethods: " + method.getParameters());
//            System.out.println("getDeclaredMethods: " + Modifier.toString(method.getModifiers()));
//            System.out.println("*************************************");
//        }

        System.out.println("------------------ 通过反射修改和操作方法 ---------------------");

        try {
            Method speak = clazz.getDeclaredMethod("speak");
            speak.invoke(null, null); //调用静态方法，可以接收返回值，返回值是Object，需要转换

            speak = clazz.getDeclaredMethod("speak", String.class);
            speak.setAccessible(true); //设置允许访问private方法
            String result = (String) speak.invoke(null, "sdc "); //调用带参数的静态方法，可以接收返回值
            System.out.println("result = " + result);

            Method sing = clazz.getDeclaredMethod("sing", null);
            sing.invoke(new Women(), null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            // 通过 InvocationTargetException.getCause() 获取被包装的异常
            System.out.println("getDeclaredMethod occur some error,Error type is :" + e.getCause().getClass().getName());
            System.out.println("Error message is :" + e.getCause().getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void getMyConstructors() {
        Class clazz = Women.class;

        System.out.println("------------------ 通过反射构获取构造方法 ---------------------");

        try {
            Constructor constructor = clazz.getConstructor(int.class, String.class);
            System.out.println("getConstructor:" + constructor.toString());
            constructor = clazz.getDeclaredConstructor(int.class);
            System.out.println("getDeclaredConstructor:" + constructor.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println();

        //getConstructors只能获取本类及父类的public构造方法
        Constructor[] constructors = clazz.getConstructors();

        for (Constructor constructor : constructors) {
            System.out.println("getConstructors:" + constructor.toString());
            //public com.sdc.designpatterns.reflect.bean.Women(int,java.lang.String)
        }

        System.out.println();

        //getDeclaredConstructors可以获取本类的所有属性构造方法
        constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            System.out.println("getDeclaredConstructors:" + constructor.toString());
            //private com.sdc.designpatterns.reflect.bean.Women()
            //public com.sdc.designpatterns.reflect.bean.Women(int,java.lang.String)
        }

        System.out.println("------------------ 通过反射构造对象 ---------------------");

        try {
            Women women = (Women) clazz.newInstance();
            System.out.println(women.toString());
            women.speak();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Constructor constructor = clazz.getConstructor(int.class, String.class);
            Women women = (Women) constructor.newInstance(22, "13244332315");
            System.out.println(women.toString());
            women.eat();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void getMyFields() {
        Class clazz = Women.class;

//        System.out.println("------------------ 通过反射获取指定属性 ---------------------");
//
//        try {
//            //getField() 方法获取的是public属性，并且 getField() 在当前 Class 获取不到时会向祖先类获取。
//            Field field = clazz.getField("height");
//            System.out.println("height method:" + field.toString());
//            field = clazz.getField("address");
//            System.out.println("address method:" + field.toString());
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//
//        try {
//            //getDeclaredField() 获取的是本 Class 中所有的属性，不能获取父类的属性
//            Field field = clazz.getDeclaredField("phone");
//            System.out.println("phone field:" + field.toString());
//            field = clazz.getDeclaredField("gender");
//            System.out.println("gender field:" + field.toString());
//            field = clazz.getDeclaredField("weight");
//            System.out.println("weight field:" + field.toString());
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("------------------ 通过反射获取所有属性 ---------------------");

//        //获取自身的所有的 public 属性，包括从父类继承下来的。
//        Field[] fields = clazz.getFields();
//
//        for (Field field : fields) {
//            System.out.println("getFields:  " + field.toString());
//            System.out.println("getFields:  " + field.getName());
//            System.out.println("getFields:  " + field.getType());
//            System.out.println("getFields:  " + field.getGenericType());
//            System.out.println("getFields:  " + Modifier.toString(field.getModifiers()));
//            System.out.println("*************************************");
//        }
//
//        System.out.println("------------------------------------------");
//
//        //获取所有的属性，但不包括从父类继承下来的属性
//        fields = clazz.getDeclaredFields();
//
//        for (Field field : fields) {
//            System.out.println("getDeclaredFields:  " + field.toString());
//            System.out.println("getDeclaredFields:  " + field.getName());
//            System.out.println("getDeclaredFields:  " + field.getType());
//            System.out.println("getDeclaredFields:  " + field.getGenericType());
//            System.out.println("getDeclaredFields:  " + Modifier.toString(field.getModifiers()));
//            System.out.println("*************************************");
//        }

        System.out.println("------------------ 通过反射修改属性值 ---------------------");

        Women women = new Women(1, "13123459900");

        //操作属性时要传入类的实例，不同的实例属性值是不同的
        try {
            Field gender = clazz.getDeclaredField("gender");
            System.out.println("gender:  " + gender.getInt(women));
            gender.setInt(women, 2);
            System.out.println("gender:  " + gender.getInt(women));

            Field weight = clazz.getDeclaredField("weight");
            System.out.println("weight:  " + weight.getFloat(women));
            weight.setFloat(women, 66.5f);
            System.out.println("weight:  " + weight.getFloat(women));

            Field phone = clazz.getDeclaredField("phone");
            phone.setAccessible(true); //访问私有变量，需要设置允许访问
            System.out.println("phone:  " + phone.get(women));
            phone.set(women, "13277778888");
            System.out.println("phone:  " + phone.get(women));

            //getField只能访问public属性，包括父类的
            Field address = clazz.getField("address");
            System.out.println("address:  " + address.get(women));
            address.set(women, "北京市软件园南街");
            System.out.println("address:  " + address.get(women));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
