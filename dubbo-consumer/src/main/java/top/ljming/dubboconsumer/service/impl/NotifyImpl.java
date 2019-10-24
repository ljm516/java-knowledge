package top.ljming.dubbboconsumer.service.impl;

import org.springframework.stereotype.Service;
import top.ljming.dubbboconsumer.service.Notify;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service(value = "notify")
public class NotifyImpl implements Notify {
    public Map<Integer, String> ret = new HashMap<>();
    public Map<Integer, Throwable> errors = new HashMap<>();

    @Override
    public void onreturn(String msg, Integer id) {
        System.out.println("onreturn： " + msg);
        ret.put(id, msg);
    }

    @Override
    public void onthrow(Throwable t, Integer id) {
        errors.put(id, t);
    }
}
