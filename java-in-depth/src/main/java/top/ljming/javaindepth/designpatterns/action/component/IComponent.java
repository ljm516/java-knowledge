package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.oberser.IComponentListener;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IComponent {
    void init(IComponentListener listener);

    Long getComponentId();

}
