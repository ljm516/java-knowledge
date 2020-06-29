package top.ljming.learning.indepth.designpatterns.decorator.geek;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class Order {

    private int id;
    private String orderNo;
    private BigDecimal totalPayMoney;
    private List<OrderDetail> list;

}
