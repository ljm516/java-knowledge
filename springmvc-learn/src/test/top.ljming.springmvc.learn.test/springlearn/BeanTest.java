package top.ljming.springmvc.learn.test.springlearn;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BeanTest {

    @Test
    public void test1() {

        ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext("classpath:application-server.xml");
        Object o = cpxa.getBean("timediff");
    }
}
