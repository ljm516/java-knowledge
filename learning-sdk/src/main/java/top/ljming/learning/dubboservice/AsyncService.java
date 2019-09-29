package top.ljming.learning.dubboservice;

import top.ljming.learning.domain.MyCompletableFuture;


/**
 * 异步调用的接口.
 *
 * @author lijm
 */
public interface AsyncService {
    public MyCompletableFuture<String> asyncInvoke(String info);
}
