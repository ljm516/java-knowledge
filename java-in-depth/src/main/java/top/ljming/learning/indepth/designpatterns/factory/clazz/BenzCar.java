package top.ljming.learning.indepth.designpatterns.factory.clazz;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BenzCar extends Car {

    public BenzCar(String name, double price) {
        super(name, price);
    }

    @Override
    public void info() {
        System.out.println("this is " + getName() + ", price is " + getPrice());
    }
}
