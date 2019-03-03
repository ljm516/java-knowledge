package com.javaReview.pattern.factoryPattern.abstractFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class BusinessCarFactory extends BusinessCarAbstractFactory {
    @Override
    BusinessCar getBenzBusinessCar() {
        return new BenzBusinessCar();
    }

    @Override
    BusinessCar getBMWBusinessCar() {
        return new BMWBusinessCar();
    }
}
