package com.javaReview.pattern.factoryPattern.simpleFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 * 具体的奔驰车
 */
public class BenzCar implements Car {
    @Override
    public void info() {
        System.out.println("this is a benz car");
    }
}
