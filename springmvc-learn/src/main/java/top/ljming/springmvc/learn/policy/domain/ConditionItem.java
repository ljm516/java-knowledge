package top.ljming.springmvc.learn.policy.domain;

import lombok.Data;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Data
public class ConditionItem extends Base {
    private String opreator;
    private String property;
    private String propertyDataType;
    private String rightValueType;
    private String type;
    private String value;
}
