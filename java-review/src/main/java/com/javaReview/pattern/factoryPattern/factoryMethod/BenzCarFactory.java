package com.javaReview.pattern.factoryPattern.factoryMethod;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class BenzCarFactory implements AbstractFactory {
    @Override
    public Car carFactory() {
        return new BenzCar();
    }
}
