package top.ljming.dubboprovider.service;

import org.apache.dubbo.config.annotation.Service;
import top.ljming.learning.dubboservice.EventNotifyService;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service
public class EventNotifyServiceImpl implements EventNotifyService {
    @Override
    public String get(int id) {
        return "event notify: " + id;
    }
}
