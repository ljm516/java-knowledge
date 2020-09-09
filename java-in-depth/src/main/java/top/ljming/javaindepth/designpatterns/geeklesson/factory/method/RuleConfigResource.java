package top.ljming.javaindepth.designpatterns.geeklesson.factory.method;

import org.springframework.util.StringUtils;
import top.ljming.javaindepth.designpatterns.geeklesson.factory.IRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class RuleConfigResource {

    private static Map<String, IRuleConfigParserFactory> configParserFactoryMap = new HashMap<>();
    static {
        configParserFactoryMap.put("json", new JSONRuleConfigParserFactory());
        configParserFactoryMap.put("yaml", new YAMLRuleConfigParserFactory());
        /*
        ...
         */
    }

    public static void main(String[] args) {
        String configType = getConfigTypeFromFile(args[0]);
        IRuleConfigParserFactory configParserFactory = configParserFactoryMap.get(configType);
        /*
        ....
         */
        IRuleConfigParser configParser = configParserFactory.createParser();
        configParser.parser();
    }

    private static String getConfigTypeFromFile(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            throw new IllegalArgumentException("....");
        }
        return fileName.split("\\.")[1];
    }
}
