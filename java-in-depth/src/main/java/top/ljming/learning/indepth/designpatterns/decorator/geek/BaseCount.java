package top.ljming.learning.indepth.designpatterns.decorator.geek;

import java.math.BigDecimal;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class BaseCount implements IBaseCount {
    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        System.out.println("商品原价金额为: " + orderDetail.getPayMoney());

        return orderDetail.getPayMoney();
    }
}
