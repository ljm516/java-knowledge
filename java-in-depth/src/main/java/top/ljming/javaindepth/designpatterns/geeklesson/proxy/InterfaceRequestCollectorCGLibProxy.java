package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import top.ljming.javaindepth.designpatterns.geeklesson.metic.RequestInfo;

import java.lang.reflect.Method;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class InterfaceRequestCollectorCGLibProxy implements MethodInterceptor {

    private Object proxiedObject;

    private InterfaceRequestCollector requestCollector;

    public InterfaceRequestCollectorCGLibProxy() {
        this.requestCollector = new InterfaceRequestCollector();
    }

    public Object createObject(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
        Enhancer enhancer = new Enhancer();
        // 设置代理了的父类为被代理的类
        enhancer.setSuperclass(proxiedObject.getClass());
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(o, objects);
        long end = System.currentTimeMillis();
        RequestInfo requestInfo = new RequestInfo(method.getName(), end - start, start);
        requestCollector.collect(requestInfo);
        return result;
    }

    public static void main(String[] args) {
        InterfaceRequestCollectorCGLibProxy requestCollectorCGLibProxy = new InterfaceRequestCollectorCGLibProxy();
        UserController userController = (UserController) requestCollectorCGLibProxy.createObject(new UserController());
    }
}
