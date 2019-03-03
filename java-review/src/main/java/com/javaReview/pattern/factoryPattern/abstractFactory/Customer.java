package com.javaReview.pattern.factoryPattern.abstractFactory;

/**
 * Created by jiangmingli on 2017/11/10.
 */
public class Customer {

    public static void main(String[] args) {
        SportsCarFactory sportsCarFactory = new SportsCarFactory();
        BusinessCarFactory businessCarFactory = new BusinessCarFactory();

        SportsCar benzSportsCar = sportsCarFactory.getBenzSportsCar();
        SportsCar bmwSportsCar = sportsCarFactory.getBMWSportsCar();

        BusinessCar bmwBusiness = businessCarFactory.getBMWBusinessCar();
        BusinessCar benBusiness = businessCarFactory.getBenzBusinessCar();

        benzSportsCar.info();
        bmwSportsCar.info();
        bmwBusiness.info();
        benBusiness.info();
    }
}
