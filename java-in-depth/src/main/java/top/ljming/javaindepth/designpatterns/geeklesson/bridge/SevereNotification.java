package top.ljming.javaindepth.designpatterns.geeklesson.bridge;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class SevereNotification extends Notification {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
