package top.ljming.learning.indepth.designpatterns.decorator.geek;

import java.math.BigDecimal;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class CouponDecorator extends BaseCountDecorator {

    public CouponDecorator(IBaseCount baseCount) {
        super(baseCount);
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        BigDecimal payTotalMoney = new BigDecimal(0);
        payTotalMoney = super.countPayMoney(orderDetail);
        payTotalMoney = countCouponPayMoney(orderDetail);

        return payTotalMoney;
    }

    private BigDecimal countCouponPayMoney(OrderDetail orderDetail) {
        BigDecimal coupon = orderDetail.getMerchandise().getSupportPromotions().get(PromotionType.COUPON).getUserCoupon().getCoupon();
        System.out.println("优惠券金额:" + coupon);

        orderDetail.setPayMoney(orderDetail.getPayMoney().subtract(coupon));
        return orderDetail.getPayMoney();
    }
}
