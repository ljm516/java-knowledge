package top.ljming.dubbboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ljming.learning.domain.MyCompletableFuture;
import top.ljming.learning.dubboservice.AsyncService;
import top.ljming.learning.dubboservice.CallbackService;
import top.ljming.learning.dubboservice.DemoService;
import top.ljming.learning.listener.DubboCallbackListener;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@RestController
public class DemoController {

    @Reference
    private DemoService demoService;

    @Reference(timeout = 10000, interfaceClass = top.ljming.learning.dubboservice.AsyncService.class)
    private AsyncService asyncService;

    @Reference(version = "1.0.0", interfaceClass =top.ljming.learning.dubboservice.CallbackService.class)
    private CallbackService callbackService;

    /**
     * getStart.
     *
     * @return string
     */
    @RequestMapping(value = "/demo")
    public String demo() {
        int arr[] = new int[]{5};
        for (int i : arr) {
            System.out.println(i);
        }
        return demoService.demo(" dubbo learn");
    }

    /**
     * 回声测试。
     * 所有的service自动实现EchoService接口，只需将服务强转成EchoService即可调用
     * 回声测试用于检测服务是否可用，回声测试按照正常请求流程执行，能够测试整个调用是否通畅，可用于监控。
     *
     * @return string
     */
    @RequestMapping(value = "/echo")
    public String echo() {
        EchoService echoService = (EchoService) demoService;
        return (String) echoService.$echo("ok");
    }

    /**
     * 上下文信息。
     * 上下文中存放的是当前调用过程中所需的环境信息。所有配置信息都将转换为 URL 的参数。
     * RpcContext 是一个 ThreadLocal 的临时状态记录器，当接收到 RPC 请求，或发起 RPC 请求时，
     * RpcContext 的状态都会变化。比如：A 调 B，B 再调 C，则 B 机器上，在 B 调 C 之前，
     * RpcContext 记录的是 A 调 B 的信息，在 B 调 C 之后，RpcContext 记录的是 B 调 C 的信息。
     *
     * @return string
     */
    @RequestMapping(value = "/context")
    public String rpcContext() {
        String invokeResult = demoService.demo("dubbo learn");

        // 本端是否为消费端，这里将返回true
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
        // 获取最后一次调用的提供方IP地址
        String serverIp = RpcContext.getContext().getRemoteHost();
        String application = RpcContext.getContext().getUrl().getParameter("application");

        // 每发起RPC调用，上下文状态会发生变化
        demoService.context("hello world");

        return "invoke: " + invokeResult +
                "isConsumerSize: " + isConsumerSide +
                "sererIp: " + serverIp +
                "application: " + application;
    }

    @RequestMapping(value = "/async-invoke")
    public String asyncInvoke() {
        MyCompletableFuture<String> future = asyncService.asyncInvoke("hi async invoke");
        AtomicReference<String> result = new AtomicReference<>();
        future.whenComplete((s, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                result.set(s);
                System.out.println("response: " + s);
            }
        });
        String invokeResult = null;
        while (invokeResult == null) {
            invokeResult = result.get();
        }
        System.out.println("invokeResult: " + invokeResult);
        return invokeResult;
    }

    @RequestMapping(value = "/callback")
    public String callback() {
        callbackService.addListener("foo.bar", (DubboCallbackListener) msg -> System.out.println("callback: " + msg));
        return "ok";
    }
}
