package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.oberser.IComponentListener;
import top.ljming.javaindepth.designpatterns.action.po.Condition;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public abstract class ConditionService implements IComponent {

    private IComponentListener listener;

    private Condition condition;
    public ConditionService(Condition condition) {
        this.condition = condition;
    }

    @Override
    public void init(IComponentListener listener) {
        this.listener = listener;
        doInit();
    }

    public IComponentListener getListener() {
        return this.listener;
    }

    @Override
    public Long getComponentId() {
        return this.condition.getId();
    }

    public abstract void doInit();

    public abstract boolean execute();

    public Condition getCondition() {
        return this.condition;
    }
}
