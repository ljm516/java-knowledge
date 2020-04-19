package top.ljming.springmvc.learn.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import top.ljming.springmvc.learn.dynamicproxy.jdk.CommonPerson;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class CglibDynamicProxyApp {
    public static void main(String[] args) {
        CglibDynamicHuangNiuProxy niuProxy = new CglibDynamicHuangNiuProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CommonPerson.class);
        enhancer.setCallback(niuProxy);

        CommonPerson commonPerson = (CommonPerson) enhancer.create();
        commonPerson.buyTicket();
    }
}
