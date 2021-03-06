package top.ljming.springmvc.learn.spring.aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.ljming.springmvc.learn.spring.aop.AopService;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class AspectApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-server.xml");
        AopService aopService = (AopService) applicationContext.getBean("aopService");
        aopService.aop("hello");
    }
}
