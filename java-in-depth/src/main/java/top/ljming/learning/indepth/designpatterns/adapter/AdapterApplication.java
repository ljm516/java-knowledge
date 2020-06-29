package top.ljming.learning.indepth.designpatterns.adapter;

/**
 * 适配器模式主程序.
 *
 * @author ljming
 */
public class AdapterApplication {

    public static void main(String[] args) {
        // 继承的方式，适配器类继承实际执行业务的类
        Print print = new PrintBannerExtends("hello");
        print.printWeak();
        print.printStrong();

        // 委托的方式，实际执行业务的类作为属性，在适配器类
        Print printWarp = new PrintBannerWrap("hello");
        printWarp.printWeak();
        printWarp.printStrong();
    }
}
