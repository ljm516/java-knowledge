package top.ljming.springmvc.learn.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理，实现InvocationHandler.
 *
 * @author lijm
 */
public class JdkDynamicHuangNiuProxy implements InvocationHandler {

    private CommonPerson target; // 目标对象，需要代理的对象

    public JdkDynamicHuangNiuProxy(CommonPerson target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("huang niu proxy buy ticket!");
        return method.invoke(target, args);
    }
}
