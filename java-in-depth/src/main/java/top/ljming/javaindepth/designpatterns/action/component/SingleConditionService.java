package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.po.Condition;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class SingleConditionService extends ConditionService {

    public SingleConditionService(Condition condition) {
        super(condition);
    }

    @Override
    public boolean execute() {
        Object left = this.getCondition().getLeftValue();
        int symbol = this.getCondition().getSymbol();
        Object right = this.getCondition().getRightValue();

        String expression = String.format("%s%s%s", left, symbol, right);
        // todo 执行
        return false;
    }

    @Override
    public void init() {

    }
}
