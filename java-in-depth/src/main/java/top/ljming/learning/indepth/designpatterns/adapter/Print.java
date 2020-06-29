package top.ljming.learning.indepth.designpatterns.adapter;

/**
 * 需求接口.
 *
 * @author ljming
 */
public interface Print {

    /**
     * 弱化输出.
     */
    void printWeak();

    /**
     * 强化输出.
     */
    void printStrong();
}
