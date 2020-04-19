package top.ljming.learning.indepth.designpatterns.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理.
 *
 * @author lijm
 */
public class CodeServiceCglibDynamicProxy implements MethodInterceptor {

    private Object target;

    public CodeServiceCglibDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("=== cglib动态代理，先设计===");
        Object ret = method.invoke(target, args);
        System.out.println("=== cglib动态代理，再测试你");
        return ret;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
