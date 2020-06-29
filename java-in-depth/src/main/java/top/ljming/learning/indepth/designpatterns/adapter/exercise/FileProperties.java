package top.ljming.learning.indepth.designpatterns.adapter.exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class FileProperties implements FileIO {

    private Properties properties;

    public FileProperties() {
        this.properties = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        properties.load(new FileReader(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        properties.store(writer, filename);
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
