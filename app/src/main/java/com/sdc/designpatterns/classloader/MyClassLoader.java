package com.sdc.designpatterns.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Description: 自定义ClassLoader
 * https://blog.csdn.net/briblue/article/details/54973413
 * 一个ClassLoader创建时如果没有指定parent，那么它的parent默认就是AppClassLoader。
 *
 * CreateTime: 2018/8/25 11:05
 * Author: ShengDecheng
 */

public class MyClassLoader extends ClassLoader {

    //以双亲委托的方式，委托给父加载器加载class，先从缓存获取，如果有则返回，没有则继续委托父加载器加载

    //自定义ClassLoader，AppClassLoader，ExtClassLoader，BootStrapClassLoader
    //AppClassLoader，加载路径：%CLASSPATH%
    //ExtClassLoader，加载路径：%JAVA_HOME%\jre\lib\ext
    //BootStrapClassLoader，加载路径：%JAVA_HOME%\jre\lib

    // Bootstrap ClassLoader是由C/C++编写的，它本身是虚拟机的一部分，所以它并不是一个JAVA类，也就是无法在java代码中获取它的引用，
    // JVM启动时通过Bootstrap类加载器加载rt.jar等核心jar包中的class文件，之前的int.class,String.class都是由它加载。
    // 然后呢，我们前面已经分析了，JVM初始化sun.misc.Launcher并创建Extension ClassLoader和AppClassLoader实例。
    // 并将ExtClassLoader设置为AppClassLoader的父加载器。Bootstrap没有父加载器，但是它却可以作用一个ClassLoader的父加载器。比如ExtClassLoader。

    private String libPath;

    public MyClassLoader(String libPath){
        this.libPath = libPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String fileName = getFileName(name);
        File file = new File(libPath, fileName);

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            while ((len = fis.read()) != -1){
                baos.write(len);
            }

            byte[] data = baos.toByteArray();
            fis.close();
            baos.close();

            return defineClass(name, data, 0, data.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private String getFileName(String packageName){
        int index = packageName.lastIndexOf("."); //最后一个点
        if (index == -1){
            return packageName + ".class";
        } else {
            return packageName.substring(index+1) + ".class";
        }
    }
}
