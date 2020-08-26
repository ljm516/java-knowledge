package top.ljming.javaindepth.designpatterns.geeklesson.factory.abstact;

import top.ljming.javaindepth.designpatterns.geeklesson.factory.IRuleConfigParser;
import top.ljming.javaindepth.designpatterns.geeklesson.factory.JSONConfigParser;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleConfig() {
        return new JSONConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemConfig() {
        return new JSONSystemConfigParser();
    }
}
