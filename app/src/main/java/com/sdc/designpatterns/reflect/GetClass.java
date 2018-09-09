package com.sdc.designpatterns.reflect;

/**
 * Description: 获取Class和Name
 * https://img-blog.csdn.net/20170706232409114?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYnJpYmx1ZQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast
 * CreateTime: 2018/9/1 16:47
 * Author: ShengDecheng
 */

public class GetClass {

    public static void main(String[] args) {

        //getMyClass();

        //getMyName();

        //getMySimpleName();

        getMyCanonicalName();
    }

    private static void getMyClass() {
        int[] a = new int[3]; //数组初始化时固定长度，列表不固定
        int[] b = new int[]{1, 2, 3};
        int[] c = {1, 2, 3};

        //方式一：不适合基本类型如 int、float 等等
        Class clazz1 = new Person().getClass();
        Class clazz2 = new int[]{}.getClass();
        Class clazz3 = new Person[]{}.getClass();
        Class clazz4 = new int[3].getClass();
        Class clazz5 = new Student[3].getClass(); //TODO 为什么输出是class而不是interface
        System.out.println("clazz1：" + clazz1.toString());  //class com.sdc.designpatterns.reflect.Person
        System.out.println("clazz2：" + clazz2.toString());  //class [I
        System.out.println("clazz3：" + clazz3.toString());  //class [Lcom.sdc.designpatterns.reflect.Person;
        System.out.println("clazz4：" + clazz4.toString());  //class [I
        System.out.println("clazz5：" + clazz5.toString());  //class [Lcom.sdc.designpatterns.reflect.Student;

        System.out.println("\n");

        //方式二：对基本数据类型和对象都适用
        Class cls1 = Person.class;
        Class cls2 = int.class;
        Class cls3 = float.class;
        Class cls4 = String.class;
        Class cls5 = Student.class;
        System.out.println("cls1：" + cls1.toString());  //class com.sdc.designpatterns.reflect.Person
        System.out.println("cls2：" + cls2.toString());  //int
        System.out.println("cls3：" + cls3.toString());  //float
        System.out.println("cls4：" + cls4.toString());  //class java.lang.String
        System.out.println("cls5：" + cls5.toString());  //interface com.sdc.designpatterns.reflect.Student

        System.out.println("\n");

        //方式三：Class.forName("全限定名称")
        try {
            //全限定名称，它包括包名+类名
            Class clz1 = Class.forName("com.sdc.designpatterns.reflect.Person");
            Class clz2 = Class.forName("com.sdc.designpatterns.reflect.Student");
            Class clz3 = Class.forName("java.lang.String");
            System.out.println("clz1：" + clz1.toString());  //class com.sdc.designpatterns.reflect.Person
            System.out.println("clz2：" + clz2.toString());  //interface com.sdc.designpatterns.reflect.Student
            System.out.println("clz3：" + clz3.toString());  //class java.lang.String
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getMyName() {

        //方式一：不适合基本类型如 int、float 等等
        Class clazz1 = new Person().getClass();
        Class clazz2 = new int[]{}.getClass();
        Class clazz3 = new Person[]{}.getClass();
        Class clazz4 = new Student[]{}.getClass();
        System.out.println("clazz1：" + clazz1.getName());   //com.sdc.designpatterns.reflect.Person
        System.out.println("clazz2：" + clazz2.getName());   //[I
        System.out.println("clazz3：" + clazz3.getName());   //[Lcom.sdc.designpatterns.reflect.Person;
        System.out.println("clazz4：" + clazz4.getName());   //[Lcom.sdc.designpatterns.reflect.Student;

        System.out.println("\n");

        //方式二：对基本数据类型和对象都适用
        Class cls1 = Person.class;
        Class cls2 = int.class;
        Class cls3 = float.class;
        Class cls4 = String.class;
        Class cls5 = Student.class;
        System.out.println("cls1：" + cls1.getName());   //com.sdc.designpatterns.reflect.Person
        System.out.println("cls2：" + cls2.getName());   //int
        System.out.println("cls3：" + cls3.getName());   //float
        System.out.println("cls4：" + cls4.getName());   //java.lang.String
        System.out.println("cls5：" + cls5.getName());   //com.sdc.designpatterns.reflect.Student

        System.out.println("\n");

        //方式三：Class.forName("全限定名称")
        try {
            //全限定名称，它包括包名+类名
            Class clz1 = Class.forName("com.sdc.designpatterns.reflect.Person");
            Class clz2 = Class.forName("com.sdc.designpatterns.reflect.Student");
            System.out.println("clz1：" + clz1.getName());   //com.sdc.designpatterns.reflect.Person
            System.out.println("clz2：" + clz2.getName());   //com.sdc.designpatterns.reflect.Student
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void getMySimpleName() {

        //方式一：不适合基本类型如 int、float 等等
        Class clazz1 = new Person().getClass();
        Class clazz2 = new int[]{}.getClass();
        Class clazz3 = new Person[]{}.getClass();
        Class clazz4 = new Student[]{}.getClass();
        System.out.println("clazz1：" + clazz1.getSimpleName()); //Person
        System.out.println("clazz2：" + clazz2.getSimpleName()); //int[]
        System.out.println("clazz3：" + clazz3.getSimpleName()); //Person[]
        System.out.println("clazz4：" + clazz4.getSimpleName()); //Student[]

        System.out.println("\n");

        //方式二：对基本数据类型和对象都适用
        Class cls1 = Person.class;
        Class cls2 = int.class;
        Class cls3 = float.class;
        Class cls4 = String.class;
        Class cls5 = Student.class;
        System.out.println("cls1：" + cls1.getSimpleName()); //Person
        System.out.println("cls2：" + cls2.getSimpleName()); //int
        System.out.println("cls3：" + cls3.getSimpleName()); //float
        System.out.println("cls4：" + cls4.getSimpleName()); //String
        System.out.println("cls5：" + cls5.getSimpleName()); //Student

        System.out.println("\n");

        //方式三：Class.forName("全限定名称")
        try {
            //全限定名称，它包括包名+类名
            Class clz1 = Class.forName("com.sdc.designpatterns.reflect.Person");
            Class clz2 = Class.forName("com.sdc.designpatterns.reflect.Student");
            System.out.println("clz1：" + clz1.getSimpleName()); //Person
            System.out.println("clz2：" + clz2.getSimpleName()); //Student
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n");

        Class clazz11 = Outter.Inner.class;
        Class clazz22 = new Outter.Inner[][][]{}.getClass();
        System.out.println("clazz11 name：" + clazz11.getName());    //com.sdc.designpatterns.reflect.Outter$Inner
        System.out.println("clazz22 name：" + clazz22.getName());    //[[[Lcom.sdc.designpatterns.reflect.Outter$Inner;
        System.out.println("clazz11 simpleName：" + clazz11.getSimpleName());    //Inner
        System.out.println("clazz22 simpleName：" + clazz22.getSimpleName());    //Inner[][][]

        System.out.println("\n");

        Runnable run = new Runnable() {

            @Override
            public void run() {

            }
        };
        System.out.println(" run Class name:" + run.getClass().getName());    //com.sdc.designpatterns.reflect.GetClass$1
        System.out.println(" run Class simple name:" + run.getClass().getSimpleName());   //
    }

    private static void getMyCanonicalName() {
        Class clazz1 = new Outter.Inner[][][]{}.getClass();
        System.out.println(" clazz1 Class name:" + clazz1.getName());     //[[[Lcom.sdc.designpatterns.reflect.Outter$Inner;
        System.out.println(" clazz1 Class name:" + clazz1.getSimpleName());   //Inner[][][]
        System.out.println(" clazz1 Class name:" + clazz1.getCanonicalName());    //com.sdc.designpatterns.reflect.Outter.Inner[][][]

        System.out.println("\n");

        Class clazz2 = int.class;
        System.out.println(" clazz2 Class name:" + clazz2.getName());     //int
        System.out.println(" clazz2 Class name:" + clazz2.getSimpleName());   //int
        System.out.println(" clazz2 Class name:" + clazz2.getCanonicalName());    //int

        System.out.println("\n");

        Class clazz3 = Person.class;
        System.out.println(" clazz3 Class name:" + clazz3.getName());     //com.sdc.designpatterns.reflect.Person
        System.out.println(" clazz3 Class name:" + clazz3.getSimpleName());   //Person
        System.out.println(" clazz3 Class name:" + clazz3.getCanonicalName());    //com.sdc.designpatterns.reflect.Person

        System.out.println("\n");

        Class clazz4 = Student.class;
        System.out.println(" clazz4 Class name:" + clazz4.getName());     //com.sdc.designpatterns.reflect.Student
        System.out.println(" clazz4 Class name:" + clazz4.getSimpleName());   //Student
        System.out.println(" clazz4 Class name:" + clazz4.getCanonicalName());    //com.sdc.designpatterns.reflect.Student

        System.out.println("\n");

        //run 是匿名类
        Runnable run = new Runnable() {

            @Override
            public void run() {

            }
        };
        System.out.println(" anonymous Class name:" + run.getClass().getName());    //com.sdc.designpatterns.reflect.GetClass$2
        System.out.println(" anonymous Class simple name:" + run.getClass().getSimpleName());   //
        System.out.println(" anonymous Class canonical name:" + run.getClass().getCanonicalName()); //null

        System.out.println("\n");

        // local 是局部类
        class Local_A {
        }
        System.out.println("Local_A name:" + Local_A.class.getName());    //com.sdc.designpatterns.reflect.GetClass$1Local_A
        System.out.println("Local_A simplename:" + Local_A.class.getSimpleName());    //Local_A
        System.out.println("Local_A canonicalname:" + Local_A.class.getCanonicalName());  //null

        class Local_B {
        }
        System.out.println("Local_B name:" + Local_B.class.getName());    //com.sdc.designpatterns.reflect.GetClass$1Local_B
        System.out.println("Local_B simplename:" + Local_B.class.getSimpleName());    //Local_B
        System.out.println("Local_B canonicalname:" + Local_B.class.getCanonicalName());  //null
    }
}
