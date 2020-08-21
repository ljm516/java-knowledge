package top.ljming.learning.indepth.designpatterns.geeklesson.factory.method;

import top.ljming.learning.indepth.designpatterns.geeklesson.factory.IRuleConfigParser;
import top.ljming.learning.indepth.designpatterns.geeklesson.factory.JSONConfigParser;
import top.ljming.learning.indepth.designpatterns.geeklesson.factory.YAMLConfigParser;

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
