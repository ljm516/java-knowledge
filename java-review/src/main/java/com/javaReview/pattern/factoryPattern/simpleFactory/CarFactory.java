package com.javaReview.pattern.factoryPattern.simpleFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 * 产品工厂类
 */
public class CarFactory {

    public static Car createCar(String type) {
        if (type.equalsIgnoreCase(BenzCar.class.getSimpleName())) {
            return new BenzCar();
        }
        if (type.equalsIgnoreCase(BmwCar.class.getSimpleName())) {
            return new BmwCar();
        }
        return null;
    }
}
