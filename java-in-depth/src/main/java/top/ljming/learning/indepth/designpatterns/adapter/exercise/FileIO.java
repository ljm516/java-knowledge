package top.ljming.learning.indepth.designpatterns.adapter.exercise;

import java.io.IOException;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public interface FileIO {
    /**
     * 从指定文件读数据.
     *
     * @param filename 文件
     * @throws IOException
     */
    void readFromFile(String filename) throws IOException;

    /**
     * 写内容到指定文件.
     *
     * @param filename 文件
     * @throws IOException
     */
    void writeToFile(String filename) throws IOException;

    /**
     * 设置值到文件.
     *
     * @param key key
     * @param value value
     */
    void setValue(String key, String value);

    /**
     * 获取值.
     *
     * @param key key
     * @return String
     */
    String getValue(String key);
}
