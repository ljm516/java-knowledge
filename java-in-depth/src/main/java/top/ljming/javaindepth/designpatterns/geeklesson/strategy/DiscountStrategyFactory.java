package top.ljming.javaindepth.designpatterns.geeklesson.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class DiscountStrategyFactory {

    private static final Map<String, DiscountStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("common", new CommonDiscountStrategy());
        strategyMap.put("group", new GroupDiscountStrategy());
        strategyMap.put("promotion", new PromotionDiscountStrategy());
    }
    
    public static DiscountStrategy getDiscountStrategy(String orderType) {
        return strategyMap.get(orderType);
    }

}
