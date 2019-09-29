package top.ljming.learning.dubboservice;

import top.ljming.learning.listener.DubboCallbackListener;

/**
 * dubbo参数回调.
 *
 * @author lijm
 */
public interface CallbackService {

    void addListener(String msg, DubboCallbackListener listener);
}