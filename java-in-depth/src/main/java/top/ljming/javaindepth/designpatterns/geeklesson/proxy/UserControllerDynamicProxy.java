package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理.
 *
 * @author ljming
 */
public class UserControllerDynamicProxy {

    private UserController userController;

    public UserControllerDynamicProxy () {
        this.userController = new UserController();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, proxyHandler);
    }


    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method.invoke(proxiedObject, args);
            return null;
        }
    }

    public static void main(String[] args) {
        UserControllerDynamicProxy controllerDynamicProxy = new UserControllerDynamicProxy();
        IUserController controller = (IUserController) controllerDynamicProxy.createProxy(new UserController());

        controller.login("11111", "222222");
    }
}
