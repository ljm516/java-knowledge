package top.ljming.learning.indepth.base;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class StringApp {

    public static void main(String[] args) {
        String word = "hello";

        System.out.println(word);

        greet(word);

        System.out.println(word);
    }

    public static void greet(String word) {
        word = "hey";
        System.out.println(word);
    }
}
