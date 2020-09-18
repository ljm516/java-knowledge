package top.ljming.javaindepth.designpatterns.action.component;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public enum CounterType {
    FREQUENCY(1),
    COUNT(2);

    private Integer type;

    private CounterType(Integer type) {
        this.type = type;
    }

    public CounterType getByType(Integer type) {
        for (CounterType counterType : CounterType.values()) {
            if (counterType.type.equals(type)) {
                return counterType;
            }
        }
        return null;
    }

    public Integer getType() {
        return this.type;
    }
}
