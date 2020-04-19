package top.ljming.learning.indepth.designpatterns.decorator;

import top.ljming.learning.indepth.designpatterns.decorator.wrapper.ManProgrammerWrapper;
import top.ljming.learning.indepth.designpatterns.decorator.wrapper.WomanProgrammerWrapper;

/**
 * 装饰器app.
 *
 * @author lijm
 */
public class DecoratorApp {

    public static void main(String[] args) {
        Person manProgrammer = new ManProgrammer();
        ManProgrammerWrapper manProgrammerWrapper = new ManProgrammerWrapper(manProgrammer);
        manProgrammerWrapper.show();

        Person womanProgrammer  = new ManProgrammer();
        WomanProgrammerWrapper womanProgrammerWrapper = new WomanProgrammerWrapper(womanProgrammer);
        womanProgrammerWrapper.show();
    }
}
