package top.ljming.learning.indepth.designpatterns.chain;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class WorkHandler extends Handler{

    public WorkHandler(Handler handler) {
        super(handler);
    }

    @Override
    void doRequest() {
        System.out.println("this is work handler finished");
        if (null != this.getNext()) {
            this.getNext().doRequest();
        }
    }
}
