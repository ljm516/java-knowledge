package top.ljming.javaindepth.designpatterns.geeklesson.observer;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class RegPromotionObserver implements RegObserver {
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("hi, " + userId + ", this is promotion Observer");
    }
}
