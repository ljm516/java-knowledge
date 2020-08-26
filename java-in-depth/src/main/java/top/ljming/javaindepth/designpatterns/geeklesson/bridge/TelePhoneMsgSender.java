package top.ljming.javaindepth.designpatterns.geeklesson.bridge;

import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class TelePhoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelePhoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("telPhoneMsgSender: " + message);
    }
}
