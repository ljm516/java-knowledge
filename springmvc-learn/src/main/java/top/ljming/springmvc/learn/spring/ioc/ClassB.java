package top.ljming.springmvc.learn.spring.ioc;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ClassB {
    private ClassC classC;

    public ClassB(ClassC classC) {
        this.classC = classC;
    }

    public ClassB() {

    }

    public void setClassC(ClassC classC) {
        this.classC = classC;
    }
}
