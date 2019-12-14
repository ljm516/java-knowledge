package top.ljming.learning.indepth.designpatterns.chain;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class FilterHandler extends Handler {

    public FilterHandler(Handler handler) {
        super(handler);
    }
    @Override
    void doRequest() {
        System.out.println("this is filter handler finished");
        if (null != this.getNext()) {
            this.getNext().doRequest();
        }
    }
}
