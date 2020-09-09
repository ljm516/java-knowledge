package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

import top.ljming.javaindepth.designpatterns.geeklesson.metic.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class InterfaceRequestCollectorProxy {
    private InterfaceRequestCollector requestCollector;

    public InterfaceRequestCollectorProxy() {
        this.requestCollector = new InterfaceRequestCollector();
    }

    public Object createObject(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(interfaces);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, proxyHandler);
    }


    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxiesObject;

        public DynamicProxyHandler(Object proxiesObject) {
            this.proxiesObject = proxiesObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = method.invoke(proxy, args);
            long end = System.currentTimeMillis();
            RequestInfo requestInfo = new RequestInfo(method.getName(), end - start, start);
            requestCollector.collect(requestInfo);
            return result;
        }
    }

    public static void main(String[] args) {
        InterfaceRequestCollectorProxy requestCollectorProxy = new InterfaceRequestCollectorProxy();
        IUserController userController = (IUserController) requestCollectorProxy.createObject(new UserController());
    }
}
