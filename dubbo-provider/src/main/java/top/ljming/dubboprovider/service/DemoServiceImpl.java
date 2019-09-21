package top.ljming.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import top.ljming.learning.dubboservice.DemoService;


/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String demo(String name) {
        return "hello world " + name;
    }
}
