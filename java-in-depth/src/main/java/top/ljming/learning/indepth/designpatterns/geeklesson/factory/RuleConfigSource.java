package top.ljming.learning.indepth.designpatterns.geeklesson.factory;

import top.ljming.learning.indepth.designpatterns.geeklesson.factory.simple.RuleConfigParserFactory;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class RuleConfigSource {

    public RuleConfig load(String configFilePath) {
        String fileType = getFileExtension(configFilePath);
        IRuleConfigParser configParser = RuleConfigParserFactory.createParser(fileType);
        return configParser.parser();
    }


    private String getFileExtension(String fileName) {
        return fileName.split("\\.")[1];
    }

}
