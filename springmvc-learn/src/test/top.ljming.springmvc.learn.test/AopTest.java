package top.ljming.springmvc.learn.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.ljming.springmvc.learn.service.AopService;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class AopTest {

    private AopService aopService;
    @Before
    public void setAopService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-server.xml");
        aopService = (AopService) context.getBean("aopService");
    }


    @Test
    public void test1() {
        String result = aopService.aop("ljm", 26);
        System.out.println("result: " + result);
    }

}
