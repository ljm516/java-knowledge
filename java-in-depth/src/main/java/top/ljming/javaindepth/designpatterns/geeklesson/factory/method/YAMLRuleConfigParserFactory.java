package top.ljming.javaindepth.designpatterns.geeklesson.factory.method;

import top.ljming.javaindepth.designpatterns.geeklesson.factory.YAMLConfigParser;
import top.ljming.javaindepth.designpatterns.geeklesson.factory.IRuleConfigParser;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class YAMLRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YAMLConfigParser();
    }
}
