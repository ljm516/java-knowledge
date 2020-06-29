package top.ljming.learning.indepth.designpatterns.decorator.geek;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Data
public class UserReadPacket {

    private int id;
    private int userId;
    private String sku;
    private BigDecimal redPacket;
}
