package com.sdc.designpatterns.reflect;

import java.util.HashMap;
import java.util.List;

/**
 * Description:
 * CreateTime: 2018/9/6 16:58
 * Author: ShengDecheng
 */

public class Women extends Person {
    int gender;

    private String phone;

    public int height;

    protected float weight;

    public List<Car> cars;

    public HashMap<String, Object> map;

    public Women(){

    }

    private Women(int gender){
        this.gender = gender;
    }

    public Women(int gender, String phone){
        this.gender = gender;
        this.phone = phone;
    }

    public void eat(){
        System.out.println("正在吃饭。。。");
    }

    public void eat(String name){
        System.out.println(name + "正在吃饭。。。");
    }

    private void walk(){
        System.out.println("正在走路。。。");
    }

    protected void sing(String name){
        System.out.println(name + "正在唱歌。。。");
    }

    public static void speak(){
        System.out.println("正在说话。。。");
    }

    private static String speak(String name){
        String result = name + "正在说话。。。";
        System.out.println(result);
        return result;
    }

    @Override
    public String toString() {
        return "Women{" +
                "gender=" + gender +
                ", phone='" + phone + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", cars=" + cars +
                ", map=" + map +
                '}';
    }
}
