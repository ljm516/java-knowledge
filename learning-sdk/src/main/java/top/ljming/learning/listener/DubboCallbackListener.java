package top.ljming.learning.listener;

import java.io.Serializable;

/**
 * dubbo参数回调listener.
 *
 * @author lijm
 */
public interface DubboCallbackListener extends Serializable {

    void changed(String msg);
}
