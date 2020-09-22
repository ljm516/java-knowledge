package top.ljming.javaindepth.designpatterns.action.factory;

import top.ljming.javaindepth.designpatterns.action.component.*;
import top.ljming.javaindepth.designpatterns.action.dao.CounterDao;
import top.ljming.javaindepth.designpatterns.action.po.Counter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class CounterFactory implements IComponentFactory {

    private CounterDao counterDao;

    public CounterFactory(CounterDao counterDao) {
        this.counterDao = counterDao;
    }


    public ConcurrentHashMap<Long, IComponent> counterServiceMap = new ConcurrentHashMap();

    @Override
    public IComponent createComponent(Long componentId) {
        CounterService counterService = (CounterService) counterServiceMap.get(componentId);
        if (null != counterService) {
            counterServiceMap.remove(componentId);
        }
        Counter counter = counterDao.getById(componentId);
        Integer type = counter.getCounterType();
        if (CounterType.FREQUENCY.getType().equals(type)) {
            counterService = new FrequencyCounterService(counter);
        } else {
            counterService = new CountCounterService(counter);
        }
        return counterService;
    }


}
