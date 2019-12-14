package top.ljming.learning.indepth.designpatterns.chain;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ChainApplication {

    public static void main(String[] args) {
        Handler checkHandle = new CheckHandler(new FilterHandler(new WorkHandler(null)));
        checkHandle.doRequest();
    }
}
