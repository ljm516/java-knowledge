package top.ljming.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import top.ljming.learning.dubboservice.CallbackService;
import top.ljming.learning.listener.DubboCallbackListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service(connections = 1, callbacks = 1000)
public class CallbackServiceImple implements CallbackService {

    private final Map<String, DubboCallbackListener> listenerMap = new ConcurrentHashMap<>();

    public CallbackServiceImple() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    for (Map.Entry<String, DubboCallbackListener> entry : listenerMap.entrySet()) {
                        try {
                            entry.getValue().changed(getChange(entry.getKey()));
                        } catch (Throwable t1) {
                            listenerMap.remove(entry.getKey());
                        }
                    }
                    Thread.sleep(5000);
                } catch (Throwable t1) {
                    t1.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String msg, DubboCallbackListener listener) {
        listenerMap.put(msg, listener);
        listener.changed(msg);
    }

    private String getChange(String key) {
        return "changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
