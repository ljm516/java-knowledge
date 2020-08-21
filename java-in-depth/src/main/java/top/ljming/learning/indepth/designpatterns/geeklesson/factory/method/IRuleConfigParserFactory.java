package top.ljming.learning.indepth.designpatterns.geeklesson.factory.method;

import top.ljming.learning.indepth.designpatterns.geeklesson.factory.IRuleConfigParser;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
