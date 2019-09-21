package top.ljming.dubbboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ljming.learning.dubboservice.DemoService;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@RestController
public class DemoController {

    @Reference
    private DemoService demoService;

    @RequestMapping(value = "/demo")
    public String demo() {
        return demoService.demo(" dubbo learn");
    }

}
