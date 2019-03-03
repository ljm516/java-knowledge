package com.javaReview.pattern.factoryPattern.abstractFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class BenzSportsCar implements SportsCar {
    @Override
    public void info() {
        System.out.println("这是一辆奔驰跑车");
    }
}
