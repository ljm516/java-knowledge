package top.ljming.javaindepth.designpatterns.geeklesson.bridge;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class EmailMsgSender implements MsgSender {

    private List<String> emails;

    public EmailMsgSender(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void send(String message) {
        System.out.println("EmailMsgSender: " + message);
    }
}
