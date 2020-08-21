package top.ljming.learning.indepth.designpatterns.geeklesson.factory;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class JSONConfigParser implements IRuleConfigParser {
    @Override
    public RuleConfig parser() {
        return new RuleConfig();
    }
}
