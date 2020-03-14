package top.ljming.dubboprovider.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Component
public class MonitorRuleManager {

    @Autowired
    MonitorDao monitorDao;

    private ConcurrentHashMap monitorRuleTable = new ConcurrentHashMap();

    boolean load() {
        List<MonitorRule> all = monitorDao.queryall();
        for (MonitorRule o : all) {
            monitorRuleTable.putIfAbsent(o.getRuleId(), o);
        }
        return true;
    }

    void updateMonitorRuleConfig(int ruleId) {
        monitorRuleTable.remove(ruleId);
        Object monitor = monitorDao.getOne(ruleId);
        monitorRuleTable.put(monitor, monitor);
    }
}
