package top.ljming.learning.indepth.designpatterns.chain;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class CheckHandler extends Handler {

    public CheckHandler(Handler next) {
        super(next);
    }

    @Override
    void doRequest() {
        System.out.println("this is check handler finished");

        if (null != this.getNext()) {
            this.getNext().doRequest();
        }
    }
}
