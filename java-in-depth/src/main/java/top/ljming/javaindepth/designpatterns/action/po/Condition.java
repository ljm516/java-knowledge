package top.ljming.javaindepth.designpatterns.action.po;

import lombok.Data;

import java.util.List;

/**
 * 条件.
 *
 * @author ljming
 */
@Data
public class Condition {

    private Long id;
    private String conditionName;
    private Object leftValue;
    private int symbol;
    private Object rightValue;
    private int conditionType;
    private int logicSymbol;
    private List<Condition> subConditionList;
}
