package top.ljming.springmvc.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.ljming.springmvc.learn.mvc.component.MyApplicationContext;
import top.ljming.springmvc.learn.mvc.component.MyEnvironment;

import java.util.Arrays;

public class SpringMvcLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-server.xml");
        MyEnvironment myEnvironment = (MyEnvironment) context.getBean("myEnvironment");
        System.out.println(Arrays.toString(myEnvironment.environment.getDefaultProfiles()));

        MyApplicationContext myContext = (MyApplicationContext) context.getBean("myApplicationContext");
        MyEnvironment environment = (MyEnvironment) myContext.applicationContext.getBean("myEnvironment");
        System.out.println(Arrays.toString(environment.environment.getDefaultProfiles()));
    }
}
