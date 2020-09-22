package top.ljming.javaindepth.designpatterns.action.component;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 组件管理中心.
 *
 * @author ljming
 */
public class ComponentManager {

    private final ConcurrentHashMap<ComponentType, HashMap<Long, IComponent>> componentTypeMap = new ConcurrentHashMap<>();

    public void register(ComponentType componentType, IComponent component) {
        Long componentId = component.getComponentId();
        componentTypeMap.computeIfAbsent(componentType, k -> new HashMap<>(16));
        componentTypeMap.get(componentType).put(componentId, component);
    }

    public void unregister(ComponentType componentType, Long componentId) {
        componentTypeMap.get(componentType).remove(componentId);
    }

}
