package top.ljming.learning.indepth.designpatterns.decorator.geek;

import java.math.BigDecimal;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class BaseCountDecorator implements IBaseCount {

    private IBaseCount baseCount;

    public BaseCountDecorator(IBaseCount baseCount) {
        this.baseCount = baseCount;
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        BigDecimal payTotalMoney = new BigDecimal(0);
        if (baseCount != null) {
            payTotalMoney = baseCount.countPayMoney(orderDetail);
        }
        return payTotalMoney;
    }
}
