package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.po.Counter;

/**
 * 描述类的功能.
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
