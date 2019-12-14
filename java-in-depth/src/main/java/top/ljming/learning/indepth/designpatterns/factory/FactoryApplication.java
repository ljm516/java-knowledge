package top.ljming.learning.indepth.designpatterns.factory;

import top.ljming.learning.indepth.designpatterns.factory.clazz.Car;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class FactoryApplication {

    public static void main(String[] args) {
        //simpleFactoryDemo();
        factoryMethod();
    }

    /**
     * 简单工厂模式.
     */
    static void simpleFactoryDemo() {
        Car benCar = SimpleFactory.createCar("benz");
        benCar.info();

        Car bmwCar = SimpleFactory.createCar("bmw");
        bmwCar.info();
    }

    /**
     * 工厂方法模式.
     */
    private static void factoryMethod() {
        AbstractFactory benCarFactory = new BenzCarFactory();
        Car benCar = benCarFactory.createCar();
        benCar.info();

        AbstractFactory bmwCarFactory = new BmwCarFactory();
        Car bmwCar = bmwCarFactory.createCar();
        bmwCar.info();
    }
}
