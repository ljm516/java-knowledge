package com.javaReview.pattern.factoryPattern.simpleFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 * 具体的宝马车
 */
public class BmwCar implements Car {
    @Override
    public void info() {
        System.out.println("this is a bmw car");
    }
}
