package top.ljming.javaindepth.designpatterns.geeklesson.strategy;

/**
 * 策略模式.
 *
 * 定义一族算法，将每个算法分别封装起来，让它们可以互相替换。策略模式可以是算法的变法独立于使用它们的客户端。
 *
 * 策略类的定义包括一个策略接口和一组实现该接口的策略类。
 * 策略的创建由工厂类类完成，封装策略创建的细节。
 * 策略模式包含一组策略可选，客户端代码如何选择使用那个策略，有两种确定的方法: 编译时静态确定和运行时动态确定。
 * 其中，"运行时动态确定"才是策略模式最典型的应用场景。
 *
 * @author ljming
 */
public class StrategyApplication {

    public static void main(String[] args) {
        String orderType = "common";
        DiscountStrategy strategy = DiscountStrategyFactory.getDiscountStrategy(orderType);
        strategy.calDiscount(orderType);
    }
}
