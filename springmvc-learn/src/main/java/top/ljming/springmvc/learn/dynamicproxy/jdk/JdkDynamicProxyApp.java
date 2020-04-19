package top.ljming.springmvc.learn.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class JdkDynamicProxyApp {
    public static void main(String[] args) {
        CommonPerson commonPerson = new CommonPerson();

        JdkDynamicHuangNiuProxy huangNiuProxy = new JdkDynamicHuangNiuProxy(commonPerson);
        // 通过Proxy.newProxyInstance生成代理对象
        Object obj = Proxy.newProxyInstance(CommonPerson.class.getClassLoader(), new Class[]{BuyTicket.class}, huangNiuProxy);
        BuyTicket buyTicket = (BuyTicket) obj;

        buyTicket.buyTicket();
    }
}
