package top.ljming.javaindepth.dsa.leetcode;

/**
 * 给定一个非负数的数组，按奇偶数排序.
 * eg：
 * [4,1,2,3] -> [4,2,1,3]
 * 下面的结果也是可以的：
 * [2,4,1,3];[2,4,3,1];[4,2,3,1]
 *
 * @author lijm
 */
public class ParitySort {
    public static void main(String[] args) {
        int[] r = solution(new int[]{3, 1, 2, 4});
        for (int n : r) {
            System.out.println(n);
        }
    }

    private static int[] solution(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        int[] r = new int[arr.length];
        int lastIndex = arr.length - 1;
        int frontIndex = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                r[frontIndex] = n;
                frontIndex++;
            } else {
                r[lastIndex] = n;
                lastIndex--;
            }
        }
        return r;
    }
}
