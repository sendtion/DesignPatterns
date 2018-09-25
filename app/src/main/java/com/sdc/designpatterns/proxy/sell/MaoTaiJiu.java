package com.sdc.designpatterns.proxy.sell;

/**
 * Description: 茅台酒
 * CreateTime: 2018/9/25 9:51
 * Author: ShengDecheng
 */

public class MaoTaiJiu implements SellWine {

    @Override
    public void maiJiu() {
        System.out.println("我卖的是茅台酒。");
    }
}
