package top.ljming.javaindepth.designpatterns.geeklesson.chainofresponsibility;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class HandlerB implements IHandler {
    @Override
    public boolean handler() {
        boolean isHandler = false;
        /**
         * do something
         */
        System.out.println("this is handler b");
        return isHandler;
    }
}
