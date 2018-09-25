package com.sdc.designpatterns.proxy.movie;

/**
 * Description:
 * CreateTime: 2018/9/25 9:29
 * Author: ShengDecheng
 */

public class Cinema implements Movie {
    RealMovie realMovie;

    public Cinema(RealMovie realMovie){
        super();
        this.realMovie = realMovie;
    }

    @Override
    public void play() {

        guangGao(true);

        realMovie.play();

        guangGao(false);
    }

    public void guangGao(boolean isStart){
        if (isStart){
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        } else {
            System.out.println("电影就要结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }
}
