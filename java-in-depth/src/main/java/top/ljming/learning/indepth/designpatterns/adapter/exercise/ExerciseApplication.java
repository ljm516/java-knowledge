package top.ljming.learning.indepth.designpatterns.adapter.exercise;

/**
 * 适配器模式练习题.
 *
 * @author ljming
 */
public class ExerciseApplication {

    public static void main(String[] args) {
        FileIO fileIo = new FileProperties();
        try {
             fileIo.readFromFile("/Users/my/learning/docs/file.txt");
             fileIo.setValue("month", "5");
             fileIo.setValue("day", "26");
             fileIo.writeToFile("/Users/my/learning/docs/file.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
