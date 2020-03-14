package top.ljming.springmvc.learn.spring;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ClassA {
    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    public ClassA() {

    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}
