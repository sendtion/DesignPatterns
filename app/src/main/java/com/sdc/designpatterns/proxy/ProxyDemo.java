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

        SellWine sellWine1 = (SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(),
                MaoTaiJiu.class.getInterfaces(), handler1);
        SellWine sellWine2 = (SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(),
                MaoTaiJiu.class.getInterfaces(), handler2);
        SellCigarette sellCigarette = (SellCigarette) Proxy.newProxyInstance(FuRongWang.class.getClassLoader(),
                FuRongWang.class.getInterfaces(), handler3);

        sellWine1.maiJiu();
        System.out.println("******************************");
        sellWine2.maiJiu();
        System.out.println("******************************");
        sellCigarette.maiYan();
    }
}
