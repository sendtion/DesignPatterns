package com.sdc.designpatterns.proxy;

import com.sdc.designpatterns.proxy.sell.FuRongWang;
import com.sdc.designpatterns.proxy.sell.GuiTaiA;
import com.sdc.designpatterns.proxy.sell.MaoTaiJiu;
import com.sdc.designpatterns.proxy.sell.SellCigarette;
import com.sdc.designpatterns.proxy.sell.SellWine;
import com.sdc.designpatterns.proxy.sell.WuLiangYe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description:
 * CreateTime: 2018/9/25 9:33
 * Author: ShengDecheng
 */

public class ProxyDemo {

    public static void main(String[] args){
        //静态代理
//        RealMovie movie = new RealMovie();
//
//        Cinema cinema = new Cinema(movie);
//
//        cinema.play();

        //动态代理
        MaoTaiJiu maoTaiJiu = new MaoTaiJiu();
        WuLiangYe wuLiangYe = new WuLiangYe();
        FuRongWang fuRongWang = new FuRongWang();

        InvocationHandler handler1 = new GuiTaiA(maoTaiJiu);
        InvocationHandler handler2 = new GuiTaiA(wuLiangYe);
        InvocationHandler handler3 = new GuiTaiA(fuRongWang);

        SellWine dynamicProxy1 = (SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(),
                MaoTaiJiu.class.getInterfaces(), handler1);
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(),
                MaoTaiJiu.class.getInterfaces(), handler2);
        SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(FuRongWang.class.getClassLoader(),
                FuRongWang.class.getInterfaces(), handler3);

        dynamicProxy1.maiJiu();
        System.out.println("******************************");
        dynamicProxy2.maiJiu();
        System.out.println("******************************");
        dynamicProxy3.maiYan();

        System.out.println("******************************");

        //动态生成的 proxy class 与 Proxy 这个类同一个包。
        //动态生成的代理类的名字是不是包名+$Proxy+id序号。
        System.out.println("dynamicProxy1 class name : " + dynamicProxy1.getClass().getName());
        System.out.println("dynamicProxy2 class name : " + dynamicProxy2.getClass().getName());
        System.out.println("dynamicProxy3 class name : " + dynamicProxy3.getClass().getName());
    }
}
