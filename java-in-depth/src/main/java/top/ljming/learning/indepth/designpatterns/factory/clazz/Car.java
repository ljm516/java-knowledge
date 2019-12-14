package top.ljming.learning.indepth.designpatterns.factory.clazz;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public abstract class Car {
    private double price;

    private String name;

    Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void info();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
