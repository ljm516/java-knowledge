package top.ljming.javaindepth.designpatterns.geeklesson.single;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class Logger {

    private FileWriter fileWriter;

    public Logger() {
        File file = new File("/data/logs/20200819.log");
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printLog(String log) {
        try {
            fileWriter.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
