package top.ljming.springmvc.learn.dynamicproxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class CglibDynamicHuangNiuProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("huangniu proxy buy ticket");
        return methodProxy.invokeSuper(o, objects);
    }
}
