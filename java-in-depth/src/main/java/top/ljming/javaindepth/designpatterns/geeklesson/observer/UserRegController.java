package top.ljming.javaindepth.designpatterns.geeklesson.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class UserRegController {

    private List<RegObserver> regObserverList = new ArrayList<>();

    public void setRegObserverList(List<RegObserver> regObserverList) {
        this.regObserverList.addAll(regObserverList);
    }

    // 同步阻塞的方式
    public Long reg(String phone, String pwd) {
        long userId = 11111;
        for (RegObserver observer : regObserverList) {
            observer.handleRegSuccess(userId);
        }

        return userId;
    }


    public static void main(String[] args) {
        List<RegObserver> observers = new ArrayList<>();
        observers.add(new RegPromotionObserver());
        observers.add(new RegNotificationObserver());

        UserRegController regController = new UserRegController();
        regController.setRegObserverList(observers);
        regController.reg("111", "11");
    }
}
