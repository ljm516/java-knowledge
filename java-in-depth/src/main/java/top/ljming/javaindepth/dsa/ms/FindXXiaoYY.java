package top.ljming.javaindepth.dsa.ms;

/**
 * 现有一个长度为n的int[] array, 保证存在一个整型数X，它在array中出现次数超过n/2,返回X的值.
 * 小药药
 *
 * @author lijm
 */
public class FindXXiaoYY {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 3, 1, 4, 1, 1};
        int n = arr.length;
        System.out.println(findX(arr, n));
    }

    private static int findX(int[] array, int n) {
        if (null == array || n == 0) {
            return -1;
        }

        int times;
        for (int i = 0; i < n; i++) {
            times = 0;
            for (int j = i; j < n; j++) {
                if (array[i] == array[j]) {
                    times++;
                }
            }
            if (times > n / 2) {
                return array[i];
            }
        }
        return -1;
    }
}
