package com.javaReview.pattern.factoryPattern.simpleFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class Customer {

    public static void main(String[] args) {
        Car car = CarFactory.createCar(BenzCar.class.getSimpleName());
        car.info();
    }
}
