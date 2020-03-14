package top.ljming.springmvc.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMvcLearnApplication {
    public static void main(String[] args) {
        System.out.println("starting");
        ApplicationContext context = new ClassPathXmlApplicationContext("application-server.xml");
        System.out.println(context.getBean("classA"));
    }
}
