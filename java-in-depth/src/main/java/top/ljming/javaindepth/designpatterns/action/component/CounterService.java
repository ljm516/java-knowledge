package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.po.Counter;

/**
 * 指标service，处理指标数据.
 *
 * @author ljming
 */
public abstract class CounterService implements IComponent {

    public Counter counter;

    public CounterService(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void init() {
        doInit();
    }

    public abstract Integer getCounterValue();

    public abstract void doInit();
}
