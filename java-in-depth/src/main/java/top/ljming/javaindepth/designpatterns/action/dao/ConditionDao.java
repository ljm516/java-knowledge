package top.ljming.javaindepth.designpatterns.action.dao;

import top.ljming.javaindepth.designpatterns.action.po.Condition;

import java.util.ArrayList;
import java.util.List;

/**
 * ConditionDao.
 *
 * @author ljming
 */
public class ConditionDao {


    public Condition getById(Long id) {
        Condition condition = new Condition();
        condition.setId(1L);
        condition.setConditionName("1");
        condition.setLeftValue("2");
        condition.setRightValue("1");
        condition.setSymbol(0);

        return condition;
    }
    public List<Condition> getByGroupId(Long groupId) {
        List<Condition> conditions = new ArrayList<>();
        Condition c1 = new Condition();
        c1.setId(1L);
        c1.setConditionName("1");
        c1.setLeftValue("2");
        c1.setRightValue("1");
        c1.setSymbol(0);

        Condition c2 = new Condition();
        c1.setId(2L);
        c1.setConditionName("2");
        c1.setLeftValue("ljm");
        c1.setRightValue("ljm");
        c1.setSymbol(0);

        conditions.add(c1);

        return conditions;
    }

}
