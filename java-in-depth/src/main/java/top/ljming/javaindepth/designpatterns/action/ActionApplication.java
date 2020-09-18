package top.ljming.javaindepth.designpatterns.action;

import top.ljming.javaindepth.designpatterns.action.component.ComponentType;
import top.ljming.javaindepth.designpatterns.action.component.IComponent;
import top.ljming.javaindepth.designpatterns.action.dao.CounterDao;
import top.ljming.javaindepth.designpatterns.action.factory.CounterFactory;
import top.ljming.javaindepth.designpatterns.action.factory.IComponentFactory;
import top.ljming.javaindepth.designpatterns.action.factory.RuleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class ActionApplication {

    private static Map<Integer, IComponentFactory> componentFactoryMap = new HashMap<>();

    static {
        componentFactoryMap.put(ComponentType.COUNTER.getType(), new CounterFactory(new CounterDao()));
        componentFactoryMap.put(ComponentType.RULE.getType(), new RuleFactory());
    }

    public static void main(String[] args) {
        ComponentType componentType = ComponentType.COUNTER;
        IComponentFactory componentFactory = componentFactoryMap.get(componentType.getType());
        IComponent component = componentFactory.createComponent(1L);
        System.out.println(component);
    }
}
