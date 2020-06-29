package top.ljming.learning.indepth.designpatterns.decorator.geek;

import java.math.BigDecimal;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IBaseCount {

    BigDecimal countPayMoney(OrderDetail orderDetail);
}
