package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class JDKDynamicProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return invoke(proxy, method, args);
    }
}
