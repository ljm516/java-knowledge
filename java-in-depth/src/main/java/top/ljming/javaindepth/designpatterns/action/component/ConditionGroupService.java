package top.ljming.javaindepth.designpatterns.action.component;

import top.ljming.javaindepth.designpatterns.action.oberser.IComponentListener;
import top.ljming.javaindepth.designpatterns.action.po.Condition;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件组.
 *
 * 条件组和嵌套条件组和单个条件，类似于文件夹的树形结构，所以这里可以使用组合模式.
 *
 * @author ljming
 */
public class ConditionGroupService extends ConditionService implements IComponent {

    private List<ConditionService> subConditionServiceList = new ArrayList<>();

    public ConditionGroupService(Condition condition) {
        super(condition);
    }

    @Override
    public boolean execute() {
        StringBuilder exBuilder = new StringBuilder();
        int idx = 0;
        for (ConditionService conditionService : subConditionServiceList) {
            boolean result = conditionService.execute();
            exBuilder.append(result);
            if (idx < subConditionServiceList.size()) {
                exBuilder.append(this.getCondition().getLogicSymbol());
            }
        }
        // todo 执行exBuilder
        return false;
    }

    @Override
    public void doInit() {
        List<Condition> subList = this.getCondition().getSubConditionList();
        for (Condition sub : subList) {
            ConditionService conditionService = new SingleConditionService(sub);
            conditionService.doInit();
            subConditionServiceList.add(conditionService);
        }
        this.getListener().initSuccess(ComponentType.CONDITION, this);
    }
}
