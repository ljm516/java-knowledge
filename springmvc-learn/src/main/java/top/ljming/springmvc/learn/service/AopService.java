package top.ljming.springmvc.learn.service;

import org.springframework.stereotype.Service;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service(value = "aopService")
public class AopService {

    public void aop(int num) {
        System.out.println("this is aop method:" + num);
    }
}