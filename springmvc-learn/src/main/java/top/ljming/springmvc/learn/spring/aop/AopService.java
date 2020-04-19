package top.ljming.springmvc.learn.spring.aop;

import org.springframework.stereotype.Service;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service(value = "aopService")
public class AopService {

    public void aop(String args) {
        System.out.println("this is aop method:" + args);
    }
}