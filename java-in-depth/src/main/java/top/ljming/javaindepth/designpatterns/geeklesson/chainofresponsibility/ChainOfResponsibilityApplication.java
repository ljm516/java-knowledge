package top.ljming.javaindepth.designpatterns.geeklesson.chainofresponsibility;

/**
 * 责任链模式.
 *
 * 将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。将这些接收对象串成一条链，并沿着这条链传递这个请求
 * 直到这个链上的某个接收对象能够处理它为止。
 *
 * @author ljming
 */
public class ChainOfResponsibilityApplication {

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());

        handlerChain.handler();
    }
}
