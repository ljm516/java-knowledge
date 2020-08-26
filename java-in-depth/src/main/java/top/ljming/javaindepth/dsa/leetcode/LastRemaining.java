package top.ljming.javaindepth.dsa.leetcode;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class LastRemaining {

    public static void main(String[] args) {
        func(10, 11);
    }

    private static int func(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = func(n - 1, m);
        System.out.println(x);
        return (m + x) % n;
    }
}
