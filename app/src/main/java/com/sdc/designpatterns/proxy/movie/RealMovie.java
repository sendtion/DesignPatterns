package com.sdc.designpatterns.proxy.movie;

/**
 * Description:
 * CreateTime: 2018/9/25 9:27
 * Author: ShengDecheng
 */

public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("您正在看电视《复仇者联盟》");
    }
}
