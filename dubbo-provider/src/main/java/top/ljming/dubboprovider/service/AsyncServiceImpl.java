package top.ljming.dubboprovider.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.ljming.learning.domain.MyCompletableFuture;
import top.ljming.learning.dubboservice.AsyncService;

import java.util.concurrent.CompletableFuture;

/**
 * 异步调用实现.
 *
 * @author lijm
 */
@Service
@Component
public class AsyncServiceImpl implements AsyncService {
    @Override
    public MyCompletableFuture<String> asyncInvoke(String info) {
        CompletableFuture<String> result = MyCompletableFuture.completedFuture(info);
        return (MyCompletableFuture<String>) result;
    }
}
