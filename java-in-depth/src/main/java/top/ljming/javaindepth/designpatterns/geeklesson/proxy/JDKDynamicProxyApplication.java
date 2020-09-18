package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class JDKDynamicProxyApplication {

    public static void main(String[] args) {
        IUserController proxiedObject = new UserController();
        IUserController proxyObject = (IUserController) Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(),
                proxiedObject.getClass().getInterfaces(), (proxy, method, args1) -> {
            System.out.println("jdk 动态代理");
            return method.invoke(proxiedObject, args1);
        });

        proxyObject.login("ssss", "aaa");
    }
}
