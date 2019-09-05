package top.ljming.learning.indepth.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class DynamicProxy {

    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);

        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);

        System.out.println("proxyHello:" + proxyHello);

        proxyHello.sayHello();
    }
}

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("hello proxy");
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoking sayHello");
        return method.invoke(target, args);
    }
}