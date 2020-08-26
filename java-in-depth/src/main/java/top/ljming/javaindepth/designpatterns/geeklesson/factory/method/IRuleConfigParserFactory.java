package top.ljming.javaindepth.designpatterns.geeklesson.factory.method;

import top.ljming.javaindepth.designpatterns.geeklesson.factory.IRuleConfigParser;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
