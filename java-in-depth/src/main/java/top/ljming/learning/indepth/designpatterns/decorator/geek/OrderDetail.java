package top.ljming.learning.indepth.designpatterns.decorator.geek;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class OrderDetail {
    private int id;
    private int orderId;
    private Merchandise merchandise;
    private BigDecimal payMoney;
}
