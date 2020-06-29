package top.ljming.learning.indepth.designpatterns.templatemethod;

/**
 * 只实现了display方法的抽象类.
 *
 * 负责实现模板方法，还负责声明模板方法中所使用到的抽象方法，这些抽象方法有子类负责实现.
 * @author ljming
 */
public abstract class AbstractDisplay {
    /**
     * 交给子类去实现的抽象方法open.
     */
    abstract void open();
    /**
     * 交给子类去实现的抽象方法print.
     */
    abstract void print();
    /**
     * 交给子类去实现的抽象方法close.
     */
    abstract void close();

    /**
     * 自身实现的display方法
     */
    void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
