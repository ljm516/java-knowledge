package top.ljming.javaindepth.designpatterns.action.oberser;

import top.ljming.javaindepth.designpatterns.action.component.IComponentManager;
import top.ljming.javaindepth.designpatterns.action.component.ComponentType;
import top.ljming.javaindepth.designpatterns.action.component.IComponent;

/**
 * 组件初始化成功监听器.
 *
 * 使用观察者模式，对组件的初始化进行监听，当组件初始化成功，将组件注册到ComponentManger中
 * @author ljming
 */
public class ComponentInitListener implements IComponentListener {

    public IComponentManager componentManager;

    public ComponentInitListener(IComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    @Override
    public void initSuccess(ComponentType componentType, IComponent component) {
        componentManager.register(componentType, component);
    }
}
