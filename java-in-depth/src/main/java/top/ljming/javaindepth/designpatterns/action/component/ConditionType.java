package top.ljming.javaindepth.designpatterns.action.component;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public enum ConditionType {
    SINGLE(1),
    GROUP(2);

    private int type;

    ConditionType(int type) {
        this.type = type;
    }

    public ConditionType getByType(int type) {
        for (ConditionType conditionType : ConditionType.values()) {
            if (conditionType.type == type) {
                return conditionType;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }
}
