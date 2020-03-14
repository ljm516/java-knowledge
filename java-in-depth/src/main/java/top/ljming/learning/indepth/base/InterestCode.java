package top.ljming.learning.indepth.base;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class InterestCode {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                for (int k = 0; k < 10000; k++) {

                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                for (int k = 0; k < 100; k++) {

                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
