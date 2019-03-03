package com.javaReview.pattern.factoryPattern.abstractFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class BenzBusinessCar implements BusinessCar {
    @Override
    public void info() {
        System.out.println("这是一辆奔驰商务车");
    }
}
