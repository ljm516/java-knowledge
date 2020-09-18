package top.ljming.javaindepth.designpatterns.action.dao;

import top.ljming.javaindepth.designpatterns.action.po.Rule;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface RuleDao {
    Rule getById(Long id);
}
