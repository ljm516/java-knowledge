package top.ljming.javaindepth.designpatterns.geeklesson.proxy;

import top.ljming.javaindepth.designpatterns.geeklesson.metic.MetricCollector;
import top.ljming.javaindepth.designpatterns.geeklesson.metic.RequestInfo;

/**
 * 代理模式.
 * 1. 基于接口而非实现编程，将原始对象替换为代理对象，为了让代码改动尽量小，代理类和被代理类需要实现同一个接口。
 * 2. 如果需要代理的类，不是接口，而又无法对原始类进行修改的情况下，可以通过继承的方式，让代理类继承原始类，然后扩展其功能。
 * @author ljming
 */
public class UserControllerProxy implements IUserController {

    private MetricCollector metricCollector;
    private IUserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricCollector = new MetricCollector();
    }

    @Override
    public void login(String phone, String pwd) {
        userController.login(phone, pwd);

        metricCollector.recordRequest(new RequestInfo());
    }

    @Override
    public void register(String phone, String pwd) {
        userController.login(phone, pwd);

        metricCollector.recordRequest(new RequestInfo());
    }

    public static void main(String[] args) {
        IUserController userController = new UserControllerProxy(new UserController());
        userController.login("11111", "2222");
    }
}
