package com.javaReview.pattern.factoryPattern.abstractFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class SportsCarFactory extends SportsCarAbstractFactory {
    @Override
    SportsCar getBenzSportsCar() {
        return new BenzSportsCar();
    }

    @Override
    SportsCar getBMWSportsCar() {
        return new BMWSportsCar();
    }
}
