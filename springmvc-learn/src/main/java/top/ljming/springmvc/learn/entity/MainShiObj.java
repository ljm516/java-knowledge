package top.ljming.springmvc.learn.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Data
public class MainShiObj implements Serializable {

    private Integer id;
    private Integer a;
    private Integer b;
    private Integer c;
    private Date createdTime;

    public MainShiObj(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public MainShiObj() {

    }
}
