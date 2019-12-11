package top.ljming.springmvc.learn.policy.service.impl;

import org.springframework.stereotype.Service;
import top.ljming.springmvc.learn.policy.service.TimeService;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
@Service(value="timediff")
public class TimeDiffServiceImpl implements TimeService {
    @Override
    public void execute() {
        System.out.println("time diff service execute");
    }
}
