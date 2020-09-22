package top.ljming.javaindepth.designpatterns.action.component;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于本地缓存的组件管理实现.
 *
 * @author ljming
 */
public class LocalCacheComponentManager implements IComponentManager {
    private final ConcurrentHashMap<ComponentType, HashMap<Long, IComponent>> componentTypeMap = new ConcurrentHashMap<>();

    @Override
    public void register(ComponentType componentType, IComponent component) {
        Long componentId = component.getComponentId();
        componentTypeMap.computeIfAbsent(componentType, k -> new HashMap<>(16));
        componentTypeMap.get(componentType).put(componentId, component);
    }

    @Override
    public void unregister(ComponentType componentType, Long componentId) {
        componentTypeMap.get(componentType).remove(componentId);
    }

}
