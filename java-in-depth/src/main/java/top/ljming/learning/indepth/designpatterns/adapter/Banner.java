package top.ljming.learning.indepth.designpatterns.adapter;

/**
 * 实际情况的业务.
 *
 * @author ljming
 */
public class Banner {

    private String value;

    public Banner(String value) {
        this.value = value;
    }

    public void showWithParen() {
        System.out.println("(" + value + ")");
    }

    public void showWithAster() {
        System.out.println("*" + value + "*");
    }
}
