package top.ljming.learning.indepth.designpatterns.decorator.geek;

import lombok.Data;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class SupportPromotions implements Cloneable {

    private int id;
    private PromotionType promotionType;
    private int priority;
    private UserCoupon userCoupon;
    private UserReadPacket userReadPacket;

    @Override
    protected SupportPromotions clone() {
        SupportPromotions supportPromotions = null;
        try {
            supportPromotions = (SupportPromotions) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return supportPromotions;
    }
}
