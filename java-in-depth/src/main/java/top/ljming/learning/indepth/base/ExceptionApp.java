package top.ljming.learning.indepth.base;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ExceptionApp {

    public static void main(String[] args) {
        int max = 0;
        int pre = 100;
        int times = max % pre == 0 ? max / pre : (max / pre) + 1;
        int time = 1;
        while (time <= times) {
            System.out.println(pre * time);
            time ++;
        }
    }

    private static void throwException() {
        try {
            System.out.println("throwException");
            throw new RuntimeException();
        } catch (Exception e) {
            throw new OutOfMemoryError();
        }
    }


}
