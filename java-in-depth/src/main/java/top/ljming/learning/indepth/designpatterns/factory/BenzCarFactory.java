package top.ljming.learning.indepth.designpatterns.factory;

import top.ljming.learning.indepth.designpatterns.factory.clazz.BenzCar;
import top.ljming.learning.indepth.designpatterns.factory.clazz.Car;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BenzCarFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new BenzCar("奔驰", 400000);
    }
}
