package top.ljming.javaindepth.designpatterns.action;

import top.ljming.javaindepth.designpatterns.action.component.IComponentManager;
import top.ljming.javaindepth.designpatterns.action.component.ComponentType;
import top.ljming.javaindepth.designpatterns.action.component.IComponent;
import top.ljming.javaindepth.designpatterns.action.component.LocalCacheComponentManager;
import top.ljming.javaindepth.designpatterns.action.dao.CounterDao;
import top.ljming.javaindepth.designpatterns.action.factory.CounterFactory;
import top.ljming.javaindepth.designpatterns.action.factory.IComponentFactory;
import top.ljming.javaindepth.designpatterns.action.factory.RuleFactory;
import top.ljming.javaindepth.designpatterns.action.oberser.ComponentInitListener;
import top.ljming.javaindepth.designpatterns.action.oberser.IComponentListener;

import java.util.HashMap;
import java.util.Map;

/**
 * 主类.
 *
 * 使用到的设计模式：
 * 1. 工厂方法模式
 * 2. 模板方法模式
 * 3. 组合模式
 * 4. 观察者模式
 *
 * @author ljming
 */
public class ActionApplication {

    private static Map<Integer, IComponentFactory> componentFactoryMap = new HashMap<>();

    private static final IComponentManager componentManager = new LocalCacheComponentManager();

    private static final IComponentListener componentListener = new ComponentInitListener(componentManager);


    static {
        componentFactoryMap.put(ComponentType.COUNTER.getType(), new CounterFactory(new CounterDao()));
        componentFactoryMap.put(ComponentType.RULE.getType(), new RuleFactory());
    }

    public static void main(String[] args) {
        ComponentType componentType = ComponentType.COUNTER;
        IComponentFactory componentFactory = componentFactoryMap.get(componentType.getType());
        IComponent component = componentFactory.createComponent(1L);
        component.init(componentListener);
        System.out.println(component);
    }
}
