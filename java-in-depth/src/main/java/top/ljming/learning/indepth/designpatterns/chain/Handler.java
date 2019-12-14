package top.ljming.learning.indepth.designpatterns.chain;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public abstract class Handler {

    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    abstract void doRequest();

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}
