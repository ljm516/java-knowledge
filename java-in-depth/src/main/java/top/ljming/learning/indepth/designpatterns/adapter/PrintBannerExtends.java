package top.ljming.learning.indepth.designpatterns.adapter;

/**
 * 适配器的角色，继承的方式，继承执行实际业务的类.
 *
 * @author ljming
 */
public class PrintBannerExtends extends Banner implements Print{

    public PrintBannerExtends(String value) {
        super(value);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
