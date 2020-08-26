package top.ljming.javaindepth.designpatterns.geeklesson.factory.method;

import top.ljming.javaindepth.designpatterns.geeklesson.factory.JSONConfigParser;
import top.ljming.javaindepth.designpatterns.geeklesson.factory.IRuleConfigParser;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class JSONRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JSONConfigParser();
    }
}
