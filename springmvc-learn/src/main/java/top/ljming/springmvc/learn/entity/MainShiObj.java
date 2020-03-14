package top.ljming.springmvc.learn.entity;

import lombok.Data;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Data
public class MainShiObj {
    private Integer id;
    private Integer a;
    private Integer b;
    private Integer c;

    public MainShiObj(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
