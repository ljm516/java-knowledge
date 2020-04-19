package top.ljming.springmvc.learn.dynamicproxy.jdk;

/**
 * jdk动态代理，被代理的类需要实现一个接口.
 *
 * @author lijm
 */
public class CommonPerson implements BuyTicket {
    @Override
    public void buyTicket() {
        System.out.println("common person buy a ticket!");
    }
}
