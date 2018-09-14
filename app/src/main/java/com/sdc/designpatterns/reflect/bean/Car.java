package com.sdc.designpatterns.reflect.bean;

/**
 * Description:
 * CreateTime: 2018/9/1 17:30
 * Author: ShengDecheng
 */

public class Car {

    private String mBand;

    private Color mColor;

    public enum Color {
        RED,
        WHITE,
        BLACK,
        BLUE,
        GREEN
    }

    public Car(){
        super();
    }

    public Car(String mBand){
        this.mBand = mBand;
    }

    public Car(String mBand, Color mColor){
        this.mBand = mBand;
        this.mColor = mColor;
    }

    public void drive(){
        System.out.println("di di di，开车了！");
    }

    @Override
    public String toString() {
        return "Car{" +
                "mBand='" + mBand + '\'' +
                ", mColor=" + mColor +
                '}';
    }
}
