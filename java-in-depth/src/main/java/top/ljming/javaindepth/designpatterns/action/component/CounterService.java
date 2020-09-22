package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.oberser.IComponentListener;
import top.ljming.javaindepth.designpatterns.action.po.Counter;

/**
 * 指标service，处理指标数据.
 *
 * 使用模板方法模式，init方法真正的初始化逻辑，放在子类实现
 *
 * @author ljming
 */
public abstract class CounterService implements IComponent {

    private Counter counter;

    private IComponentListener listener;

    public CounterService(Counter counter) {
        this.counter = counter;
    }

    public IComponentListener getListener() {
        return this.listener;
    }

    @Override
    public final void init(IComponentListener listener) {
        this.listener = listener;
        doInit();
    }

    @Override
    public Long getComponentId() {
        return this.counter.getId();
    }

    public abstract Integer getCounterValue();

    public abstract void doInit();
}
