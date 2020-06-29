package top.ljming.learning.indepth.designpatterns.templatemethod;

/**
 * 模板方法模式主程序.
 *
 * @author ljming
 */
public class TemplateMethodApplication {

    public static void main(String[] args) {
        AbstractDisplay cd = new CharDisplay('H');

        AbstractDisplay sd = new StringDisplay("Hello world");

        cd.display();
        sd.display();

    }
}
