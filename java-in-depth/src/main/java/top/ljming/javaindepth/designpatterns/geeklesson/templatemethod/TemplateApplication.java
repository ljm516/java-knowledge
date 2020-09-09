package top.ljming.javaindepth.designpatterns.geeklesson.templatemethod;

/**
 * 模板方法模式.
 *
 * 模板方式模式在一个方法中第一一个算法骨架，并将某些步骤推迟到子类中实现。
 * 模板方法模式可以让子类在不改变算法的整体结构的情况下，重新定义算法中的某些步骤。
 *
 * @author ljming
 */
public class TemplateApplication {

    public static void main(String[] args) {
        TemplateMethodAbstractClass abstractClass = new ConcreateClass1();
        abstractClass.templateMethod();
    }
}
