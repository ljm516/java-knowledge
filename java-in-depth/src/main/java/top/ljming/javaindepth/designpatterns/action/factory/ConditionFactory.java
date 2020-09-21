package top.ljming.javaindepth.designpatterns.action.factory;

import top.ljming.javaindepth.designpatterns.action.component.*;
import top.ljming.javaindepth.designpatterns.action.dao.ConditionDao;
import top.ljming.javaindepth.designpatterns.action.po.Condition;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class ConditionFactory implements IComponentFactory {

    private ConditionDao conditionDao;

    private ConditionFactory(ConditionDao conditionDao) {
        this.conditionDao = conditionDao;
    }

    @Override
    public IComponent createComponent(Long componentId) {
        Condition condition = conditionDao.getById(componentId);
        IComponent component;
        if (ConditionType.SINGLE.getType() == condition.getConditionType()) {
            List<Condition> subList = conditionDao.getByGroupId(condition.getId());
            condition.setSubConditionList(subList);
            component = new ConditionGroupService(condition);
        } else {
            component = new SingleConditionService(condition);
        }
        component.init();
        return component;
    }
}
