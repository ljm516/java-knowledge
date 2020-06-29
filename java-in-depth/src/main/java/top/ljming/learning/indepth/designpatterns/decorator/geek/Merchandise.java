package top.ljming.learning.indepth.designpatterns.decorator.geek;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class Merchandise {

    /**
     * 商品sku
     */
    private String sku;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 支持促销类型
     */
    private Map<PromotionType, SupportPromotions> supportPromotions;
}
