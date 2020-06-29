package top.ljming.learning.indepth.designpatterns.builder;

/**
 * Builder类.
 *
 * @author ljming
 */
public abstract class Builder {

    /**
     * 编写标题.
     *
     * @param title title
     */
    abstract void makeTitle(String title);

    /**
     * 编写字符串.
     *
     * @param str str
     */
    abstract void makeString(String str);

    /**
     * 编写条目.
     *
     * @param items items
     */
    abstract void makeItems(String[] items);

    /**
     * 完成.
     */
    abstract void close();
}
