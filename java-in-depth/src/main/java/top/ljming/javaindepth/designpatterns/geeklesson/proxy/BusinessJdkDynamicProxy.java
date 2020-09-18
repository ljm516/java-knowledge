package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

import java.lang.reflect.Proxy;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class BusinessJdkDynamicProxy {

    public Object createProxyObject(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        JDKDynamicProxyHandler proxyHandler = new JDKDynamicProxyHandler();
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, proxyHandler);
    }
}
