package top.ljming.springmvc.learn.policy.domain;

import lombok.Data;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Data
public class Condition extends Base {

    private String logicOperator;
    private String property;
    private String type;
    private String params;
    private String descripe;

    private List<Base> children;

}
