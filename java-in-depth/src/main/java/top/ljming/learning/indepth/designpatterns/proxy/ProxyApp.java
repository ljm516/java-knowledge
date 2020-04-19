package top.ljming.learning.indepth.designpatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ProxyApp {

    public static void main(String[] args) {
//        jdkDynamicProxyMethod();
        cglibDynamicProxyMethod();
    }


    // 静态代理
    private static void staticProxyMethod() {
        ICoderService coderService = new CoderServiceImpl();

        CoderServiceProxy coderServiceProxy = new CoderServiceProxy(coderService);

        coderServiceProxy.writerCode();
    }

    // jdk动态代理

    /**
     *
     */
    private static void jdkDynamicProxyMethod() {
        ICoderService coderService = new CoderServiceImpl();

        Object obj = Proxy.newProxyInstance(coderService.getClass().getClassLoader(),
                coderService.getClass().getInterfaces(), (proxy, method, args) -> {
                    System.out.println("jdk动态代理，先设计");
                    method.invoke(coderService, args);
                    System.out.println("jdk动态代理，在测试");
                    return null;
                });
        ICoderService coderServiceProxy = (ICoderService) obj;
        coderServiceProxy.writerCode();
    }

    // cglib动态代理
    private static void cglibDynamicProxyMethod() {
        ICoderService coderService = new CoderServiceImpl();

        Object obj = new CodeServiceCglibDynamicProxy(coderService).getProxyInstance();

        ICoderService coderServiceProxy = (ICoderService) obj;

        coderServiceProxy.writerCode();
    }
}
