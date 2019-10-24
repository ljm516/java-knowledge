package top.ljming.learning.dubboservice;

import top.ljming.learning.domain.MyCompletableFuture;

import java.util.concurrent.CompletableFuture;


/**
 * 异步调用的接口.
 *
 * @author lijm
 */
public interface AsyncService {
    MyCompletableFuture<String> asyncInvoke(String info);

    CompletableFuture<String> asyncDemo(String info);
}
