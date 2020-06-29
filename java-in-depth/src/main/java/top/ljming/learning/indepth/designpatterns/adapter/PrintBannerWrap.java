package top.ljming.learning.indepth.designpatterns.adapter;

/**
 * 委托的方式，适配类持有实际执行业务类的对象.
 *
 * @author ljming
 */
public class PrintBannerWrap implements Print {

    private Banner banner;

    public PrintBannerWrap(String value) {
        this.banner = new Banner(value);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
