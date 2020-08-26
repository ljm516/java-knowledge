package top.ljming.javaindepth.dsa.ms;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class Blf {

    Integer max = Integer.MIN_VALUE;

    public int solution(int[] items) {
        boolean[] t = new boolean[items.length];
        int total = 0;
        func(items, 0, total, t);
        return max / 3;
    }

    public void func(int[] items, int i, int total, boolean[] t) {
        if (items == null || items.length == 0 || i < 0 || i > items.length) {
            return;
        }
        if (i == items.length) {
            if (total > max) {
                max = total;
            }
            return;
        }
        if (t[i]) {
            return;
        }
        t[i] = true;
        func(items, i + 1, total, t); // 不
        if (items[i] % 3 == 0) {
            func(items, i + 1, total + items[i], t); // 放
        }
    }

    public static void main(String[] args) {
        Blf blf = new Blf();
        int[] items = {3, 5, 6, 9, 1, 4, 3, 9};
        System.out.println(blf.solution(items));
    }

}
