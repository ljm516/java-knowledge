package top.ljming.learning.indepth.designpatterns.decorator.geek;

import java.math.BigDecimal;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class RepacketDecorator extends BaseCountDecorator {
    public RepacketDecorator(IBaseCount baseCount) {
        super(baseCount);
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        BigDecimal payTotalMoney = new BigDecimal(0);
        payTotalMoney = super.countPayMoney(orderDetail);
        payTotalMoney = countRedpacketPayMoney(orderDetail);

        return payTotalMoney;
    }

    public BigDecimal countRedpacketPayMoney(OrderDetail orderDetail) {
        BigDecimal redpacket = orderDetail.getMerchandise().getSupportPromotions().get(PromotionType.REDPACKET).getUserReadPacket().getRedPacket();
        System.out.println("红包优惠金额: " + redpacket);

        orderDetail.setPayMoney(orderDetail.getPayMoney().subtract(redpacket));

        return orderDetail.getPayMoney();
    }
}
