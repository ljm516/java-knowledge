package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.po.Counter;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class CountCounterService extends CounterService {

    public CountCounterService(Counter counter) {
        super(counter);
    }

    @Override
    public Integer getCounterValue() {
        return null;
    }

    @Override
    public void doInit() {
        // 执行init动作
        this.getListener().initSuccess(ComponentType.COUNTER, this);
    }


}
