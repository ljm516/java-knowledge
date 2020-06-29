package top.ljming.learning.indepth.designpatterns.iterator;

/**
 * 遍历集合的接口.
 *
 * 角色: 迭代器.
 * @author ljming
 */
public interface Iterator {

    /**
     * 判断是否有下一个元素.
     *
     * @return boolean
     */
    boolean hasNext();

    /**
     * 返回集合的下一个元素.
     *
     * @return Object
     */
    Object next();
}
