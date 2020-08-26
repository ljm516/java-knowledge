package top.ljming.javaindepth.dsa.leetcode;

/**
 * 按摩师 马杀鸡.
 *
 * @author lijm
 */
public class Message {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(func(nums));

    }

    private static int func(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            int c = Math.max(b, a + num);
            a = b;
            b = c;
        }
        return b;
    }
}
