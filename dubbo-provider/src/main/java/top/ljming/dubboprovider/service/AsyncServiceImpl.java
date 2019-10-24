package top.ljming.dubboprovider.service;

import org.apache.dubbo.config.annotation.Service;
import top.ljming.learning.domain.MyCompletableFuture;
import top.ljming.learning.dubboservice.AsyncService;

import java.util.concurrent.CompletableFuture;

/**
 * 异步调用实现.
 *
 * @author lijm
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    public MyCompletableFuture<String> asyncInvoke(String info) {
        CompletableFuture<String> result = MyCompletableFuture.completedFuture(info);
        return (MyCompletableFuture<String>) result;
    }

    @Override
    public CompletableFuture<String> asyncDemo(String info) {
        return CompletableFuture.completedFuture(info);
    }


}
