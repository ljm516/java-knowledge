package top.ljming.learning.indepth.dsa.lesson.geekbang;

/**
 * 在一个非负整数 a 中，我们希望从中移除 k 个数字，让剩下的数字值最小，如何选择移除哪 k 个数字呢？.
 *
 * @author lijm
 */
public class RemainMin {

    public int[] removeKNums(int nums, int k) {

        int start = nums;
        int r[] = new int[k];
        while (k > 0) {
            int last = start % 10;
            int prev = start;
            int d = 1;
            while (prev > 10) {
                prev = prev / 10;
                d *= 10;
            }
            if (prev > last) {
                start = start % d;
                r[k-1]=prev;
            } else {
                start = start / 10;
                r[k-1]=last;
            }
            k--;
        }
        System.out.println(start);
        return r;
    }

    public static void main(String[] args) {
        RemainMin remainMin = new RemainMin();
        int[] r = remainMin.removeKNums(453134, 3);
        for (int i : r) {
            System.out.println(i);
        }
    }
}
