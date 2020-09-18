package top.ljming.javaindepth.designpatterns.action.factory;

import top.ljming.javaindepth.designpatterns.action.component.IComponent;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IComponentFactory {

    IComponent createComponent(Long componentId);
}
