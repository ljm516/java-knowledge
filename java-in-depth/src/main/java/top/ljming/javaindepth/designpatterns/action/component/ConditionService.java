package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.po.Condition;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public abstract class ConditionService implements IComponent {

    private Condition condition;
    public ConditionService(Condition condition) {
        this.condition = condition;
    }

    public abstract boolean execute();

    public Condition getCondition() {
        return this.condition;
    }
}
