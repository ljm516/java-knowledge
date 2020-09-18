package top.ljming.javaindepth.designpatterns.action.dao;

import top.ljming.javaindepth.designpatterns.action.component.CounterType;
import top.ljming.javaindepth.designpatterns.action.po.Counter;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class CounterDao {

    public Counter getById(Long id) {
        Counter counter = new Counter();
        counter.setId(id);
        counter.setCounterName("test");
        counter.setCounterType(CounterType.FREQUENCY.getType());
        return counter;
    }
}
