package top.ljming.javaindepth.designpatterns.geeklesson.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class HandlerChain {
    private List<IHandler> handlerList = new ArrayList<>();

    public void addHandler(IHandler handler) {
        handlerList.add(handler);
    }

    public void handler() {
        for (IHandler handler : handlerList) {
            boolean handled = handler.handler();
        }
    }
}
