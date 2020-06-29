package top.ljming.learning.indepth.designpatterns.iterator;

/**
 * 表示集合的接口.
 *
 * 角色: 负责定义创建Iterator角色的接口.
 * @author ljming
 */
public interface Aggregate {

    /**
     * 生成用于遍历集合的迭代器
     *
     * @return Iterator
     */
    Iterator iterator();
}
