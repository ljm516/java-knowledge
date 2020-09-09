package top.ljming.javaindepth.designpatterns.geeklesson.strategy;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface DiscountStrategy {
    double calDiscount(String orderType);
}
