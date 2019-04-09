package top.ljming.springmvc.learn.policy.domain;

import lombok.Data;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Data
public class ConditionItemGroup extends Base {
    private String logicOperator;
    private String type;
    private List<ConditionItem> children;
}
