package top.ljming.javaindepth.designpatterns.action.factory;

import top.ljming.javaindepth.designpatterns.action.component.IComponent;

/**
 * 使用工厂方法模式，创建组件.
 *
 * @author ljming
 */
public interface IComponentFactory {

    IComponent createComponent(Long componentId);
}
