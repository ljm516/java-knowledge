package top.ljming.learning.indepth.designpatterns.decorator.geek;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class GeekDecoratorApp {

    public static void main(String[] args) {
        Order order = new Order();
        init(order);
        for (OrderDetail orderDetail : order.getList()) {
            BigDecimal payMoney = PromotionFactory.getPayMoney(orderDetail);
            orderDetail.setPayMoney(payMoney);
            System.out.println("最终支付金额: " + orderDetail.getPayMoney());
        }
    }

    private static void init(Order order) {
        List<OrderDetail> orderDetailList = new ArrayList<>();

    }
}
