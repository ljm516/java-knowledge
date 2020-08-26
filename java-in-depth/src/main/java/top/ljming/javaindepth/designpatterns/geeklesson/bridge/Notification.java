package top.ljming.javaindepth.designpatterns.geeklesson.bridge;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
