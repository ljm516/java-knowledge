package top.ljming.javaindepth.designpatterns.geeklesson.templatemethod;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public abstract class TemplateMethodAbstractClass {

    /**
     * 模板方法，定义为final，可以避免别子类重写。但并不是必须的
     */
    public final void templateMethod() {
        method1();

        method2();
    }


    protected abstract void method1();

    protected abstract void method2();

}
