package top.ljming.javaindepth.dsa.leetcode;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class MostWater {

    public int func(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int first = 0;
        int end = nums.length - 1;
        int maxWater = 0;
        while (first < end) {
            maxWater = Math.max(maxWater, (end - first) * Math.min(nums[first], nums[end]));
            if (nums[first] < nums[end]) {
                first++;
            } else {
                end--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        MostWater mostWater = new MostWater();
        System.out.println(mostWater.func(new int[]{1, 2, 1}));
    }
}
