package top.ljming.springmvc.learn.entity;

import lombok.Data;

import java.util.Date;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Data
public class PhoneInfo {
    private Integer id;
    private String number;
    private String head;
    private Integer headNum;
    private String operator;
    private String province;
    private String city;
    private Date createdTime;

    public PhoneInfo(String number, String head,
                     Integer headNum, String operator, String province, String city) {
        this.number = number;
        this.head = head;
        this.headNum = headNum;
        this.operator = operator;
        this.province = province;
        this.city = city;
    }
}
