package com.sdc.designpatterns.proxy.sell;

/**
 * Description: 芙蓉王
 * CreateTime: 2018/9/25 10:21
 * Author: ShengDecheng
 */

public class FuRongWang implements SellCigarette {

    @Override
    public void maiYan() {
        System.out.println("我卖的是芙蓉王。");
    }
}
