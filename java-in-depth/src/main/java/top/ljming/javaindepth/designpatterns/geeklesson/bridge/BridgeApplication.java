package top.ljming.javaindepth.designpatterns.geeklesson.bridge;

import java.util.Collections;

/**
 * 桥接模式.
 *
 * 将抽象和实现解耦，让它们可以独立变化。
 * 一个类存在两个或多个独立变化的维度，可以通过组合的方式，让两个或多个维度可以独立进行扩展。
 *
 *
 * @author ljming
 */
public class BridgeApplication {

    public static void main(String[] args) {
        /**
         * 这里将信息通知方式和信息紧急程度解耦，各自有不同的实现方式，然后通过组合的方式进行组合使用。
         */
        MsgSender telPhoneMsgSender = new TelePhoneMsgSender(Collections.singletonList("15210544796"));
        MsgSender emailMsgSender = new EmailMsgSender(Collections.singletonList("605057476@qq.com"));

        Notification normalTel = new NormalNotification(telPhoneMsgSender);
        Notification normalEmail = new NormalNotification(emailMsgSender);

        Notification severeTel = new SevereNotification(telPhoneMsgSender);
        Notification severeEmail = new SevereNotification(emailMsgSender);

        normalTel.notify("normal tel notification");
        severeTel.notify("severe tel notification");

        normalEmail.notify("normal email notification");
        severeEmail.notify("severe email notification");

    }
}
