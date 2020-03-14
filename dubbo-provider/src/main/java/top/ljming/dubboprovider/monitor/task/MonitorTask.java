package top.ljming.dubboprovider.monitor.task;

import top.ljming.dubboprovider.monitor.MonitorRule;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class MonitorTask implements Runnable {
    private MonitorRule monitorRule;
    private boolean running;

    @Override
    public void run() {
        if (running) {
            // todo 统计，判断，报警
        }
    }
}
