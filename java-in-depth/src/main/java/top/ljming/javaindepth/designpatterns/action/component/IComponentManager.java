package top.ljming.javaindepth.designpatterns.action.component;

/**
 * 组件管理中心.
 *
 * 基于接口而非继承编程。遵循里式替换原则。
 *
 * @author ljming
 */
public interface IComponentManager {

    void register(ComponentType componentType, IComponent component);

    void unregister(ComponentType componentType, Long componentId);
}
