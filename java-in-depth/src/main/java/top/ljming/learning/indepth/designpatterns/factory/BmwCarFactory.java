package top.ljming.learning.indepth.designpatterns.factory;

import top.ljming.learning.indepth.designpatterns.factory.clazz.BmwCar;
import top.ljming.learning.indepth.designpatterns.factory.clazz.Car;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BmwCarFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new BmwCar("宝马", 300000);
    }
}