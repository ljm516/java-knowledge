package top.ljming.springmvc.learn.spring.ioc;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ClassC {

    private ClassA classA;

    public ClassC(ClassA classA) {
        this.classA = classA;
    }

    public ClassC() {
    }

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }
}
