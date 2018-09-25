package com.sdc.designpatterns.proxy.sell;

/**
 * Description: 五粮液
 * CreateTime: 2018/9/25 10:15
 * Author: ShengDecheng
 */

public class WuLiangYe implements SellWine {

    @Override
    public void maiJiu() {
        System.out.println("我卖的是五粮液。");
    }
}
