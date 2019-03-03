package com.javaReview.pattern.factoryPattern.factoryMethod;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class Customer {

    public static void main(String[] args) {
        BenzCarFactory benzCarFactory = new BenzCarFactory();
        Car benzCar = benzCarFactory.carFactory();

        BmwCarFactory bmwCarFactory = new BmwCarFactory();
        Car bmwCar = bmwCarFactory.carFactory();

        benzCar.info();
        bmwCar.info();
    }
}
