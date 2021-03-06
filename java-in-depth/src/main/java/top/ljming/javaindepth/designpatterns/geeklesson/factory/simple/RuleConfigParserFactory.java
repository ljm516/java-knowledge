package top.ljming.javaindepth.designpatterns.geeklesson.factory.simple;

import top.ljming.javaindepth.designpatterns.geeklesson.factory.*;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class RuleConfigParserFactory {

    public static IRuleConfigParser createParser(String configType) {
        if ("json".equalsIgnoreCase(configType)) {
            return new JSONConfigParser();
        }
        if ("xml".equalsIgnoreCase(configType)) {
            return new XMLConfigParser();
        }
        if ("yaml".equalsIgnoreCase(configType)) {
            return new YAMLConfigParser();
        }
        if ("properties".equalsIgnoreCase(configType)) {
            return new PropertiesConfigParser();
        }
        throw new RuntimeException("unknown configType");
    }
}
