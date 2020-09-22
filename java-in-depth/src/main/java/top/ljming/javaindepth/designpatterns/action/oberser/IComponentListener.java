package top.ljming.javaindepth.designpatterns.action.oberser;

import top.ljming.javaindepth.designpatterns.action.component.ComponentType;
import top.ljming.javaindepth.designpatterns.action.component.IComponent;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IComponentListener {

    void initSuccess(ComponentType componentType, IComponent component);
}
