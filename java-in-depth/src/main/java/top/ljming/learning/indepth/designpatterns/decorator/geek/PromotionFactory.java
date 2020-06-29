package top.ljming.learning.indepth.designpatterns.decorator.geek;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class PromotionFactory {

    public static BigDecimal getPayMoney(OrderDetail orderDetail) {
        Map<PromotionType, SupportPromotions> supportPromotionsList = orderDetail.getMerchandise().getSupportPromotions();

        IBaseCount baseCount = new BaseCount();
        if (!CollectionUtils.isEmpty(supportPromotionsList)) {
            for (PromotionType promotionType : supportPromotionsList.keySet()) {
                baseCount = promotion(supportPromotionsList.get(promotionType), baseCount);
            }
        }
        return baseCount.countPayMoney(orderDetail);
    }

    private static IBaseCount promotion(SupportPromotions supportPromotions, IBaseCount baseCount) {
        if (supportPromotions.getPromotionType() == PromotionType.COUPON) {
            baseCount = new CouponDecorator(baseCount);
        } else if (supportPromotions.getPromotionType() == PromotionType.REDPACKET) {
            baseCount = new RepacketDecorator(baseCount);
        }

        return baseCount;
    }
}
