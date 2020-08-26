package top.ljming.javaindepth.designpatterns.geeklesson.factory.abstact;

import top.ljming.javaindepth.designpatterns.geeklesson.factory.IRuleConfigParser;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IConfigParserFactory {
    IRuleConfigParser createRuleConfig();
    ISystemConfigParser createSystemConfig();
}
