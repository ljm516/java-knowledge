package top.ljming.javaindepth.designpatterns.action.component;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public enum ComponentType {
    COUNTER(1),
    RULE(2),
    CONDITION(3);
    private Integer type;

    ComponentType(Integer type) {
        this.type = type;
    }

    public ComponentType getByType(Integer type) {
        for (ComponentType componentType : ComponentType.values()) {
            if (componentType.type.equals(type)) {
                return componentType;
            }
        }
        return null;
    }
    public Integer getType() {
        return this.type;
    }
}
