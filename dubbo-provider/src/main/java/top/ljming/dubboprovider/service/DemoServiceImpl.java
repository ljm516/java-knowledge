package top.ljming.dubboprovider.service;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import top.ljming.learning.dubboservice.DemoService;


/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service(provider = "dubbo-learn")
public class DemoServiceImpl implements DemoService {

    @Override
    public String demo(String name) {
        return "hello world " + name;
    }

    @Override
    public void context(String s) {
        // 本端是否为提供者，这里返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("init isProviderSide: " + isProviderSide);
        // 获取调用方IP
        String clientIp = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");

        // 注意：每发起RPC调用，上下文状态会变化
        String invokeResult = demo("hello man");

        // 这里调用自己的方法，应该不会变化，因为不是一个rpc调用。
        isProviderSide = RpcContext.getContext().isProviderSide();

        System.out.println("end result, isProvider: " + isProviderSide + ", clientIp: " + clientIp +
                ", application: " + application + "invokeResult: " + invokeResult);
    }

}
