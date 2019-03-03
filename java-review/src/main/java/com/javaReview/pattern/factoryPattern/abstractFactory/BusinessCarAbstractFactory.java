package com.javaReview.pattern.factoryPattern.abstractFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public abstract class BusinessCarAbstractFactory {
    abstract BusinessCar getBenzBusinessCar();
    abstract BusinessCar getBMWBusinessCar();
}
