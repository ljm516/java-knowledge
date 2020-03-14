package top.ljming.dubboprovider.monitor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.ljming.dubboprovider.monitor.task.MonitorTask;

import java.util.List;
import java.util.concurrent.*;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Component
public class MonitorStartup implements InitializingBean {

    @Autowired
    private MonitorDao monitorDao;

    private ConcurrentHashMap<Integer, MonitorRule> monitorRuleTable = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, MonitorTask> monitorTaskTable = new ConcurrentHashMap<>();
    private ScheduledExecutorService scheduledExecutorService;
    private ConcurrentHashMap<Integer, ScheduledFuture> scheduledFutureTable = new ConcurrentHashMap<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        scheduledExecutorService = new ScheduledThreadPoolExecutor(200, new ThreadPoolExecutor.CallerRunsPolicy());
        loadMonitorConfig();
    }

    private void loadMonitorConfig() {
        List<MonitorRule> list = monitorDao.queryall();
        for (MonitorRule rule : list) {
            monitorRuleTable.put(rule.getRuleId(), rule);
        }
    }

    private void start() {
        monitorRuleTable.forEach((key, value) -> {
            MonitorTask task = new MonitorTask();
            ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(task, 60000, value.getIntervalValue(), TimeUnit.MICROSECONDS);
            scheduledFutureTable.put(key, scheduledFuture);
            monitorTaskTable.put(key, task);

        });
    }

    private boolean updateMonitor(Integer ruleId) {
        ScheduledFuture scheduledFuture = scheduledFutureTable.get(ruleId);
        scheduledFuture.cancel(false);
        MonitorTask task = monitorTaskTable.get(ruleId);
        task = null;
        return false;

    }
}
