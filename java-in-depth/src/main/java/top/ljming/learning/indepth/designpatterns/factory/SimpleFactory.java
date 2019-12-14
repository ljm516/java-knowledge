package top.ljming.learning.indepth.designpatterns.factory;

import top.ljming.learning.indepth.designpatterns.factory.clazz.BenzCar;
import top.ljming.learning.indepth.designpatterns.factory.clazz.BmwCar;
import top.ljming.learning.indepth.designpatterns.factory.clazz.Car;

/**
 * 简单工厂方法，又称为静态工厂方法模式.
 *
 * @author lijm
 */
class SimpleFactory {

    static Car createCar(String type) {
        if (null == type) {
            return null;
        }
        if ("bmw".equals(type)) {
            return new BmwCar("宝马", 300000);
        }
        if ("benz".equals(type)) {
            return new BenzCar("奔驰", 400000);
        }

        return null;
    }
}
