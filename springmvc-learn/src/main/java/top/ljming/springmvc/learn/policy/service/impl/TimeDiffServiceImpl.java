package top.ljming.springmvc.learn.policy.service.impl;

import top.ljming.springmvc.learn.policy.service.TimeService;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class TimeDiffServiceImpl implements TimeService {
    @Override
    public void execute() {
        System.out.println("time diff service execute");
    }
}
