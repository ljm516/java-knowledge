package top.ljming.javaindepth.designpatterns.geeklesson.strategy;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class GroupDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(String orderType) {
        return 0;
    }
}
