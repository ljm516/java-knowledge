package top.ljming.javaindepth.designpatterns.geeklesson.templatemethod;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class ConcreateClass2 extends TemplateMethodAbstractClass {
    @Override
    protected void method1() {
        System.out.println("concreateClass2 实现method1");
    }

    @Override
    protected void method2() {
        System.out.println("concreateClass2 实现method2");
    }
}
