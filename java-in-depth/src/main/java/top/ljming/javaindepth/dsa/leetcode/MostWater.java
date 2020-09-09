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

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int pre = 0;
        int next = 1;
        int max = 0;
        while (pre < heights.length - 1) {
            if (heights[next] < heights[pre]) {
                max = Math.max(max, (next - pre + 1) * Math.min(heights[pre], heights[next]));
                pre++;
            } else {
                while (heights[next] >= heights[pre] && next < heights.length - 1) {
                    next++;
                }
                max = Math.max(max, (next - pre + 1) * Math.min(heights[pre], heights[next]));
                pre = next;
            }
            next++;

        }
        return max;
    }

    public static void main(String[] args) {
        MostWater mostWater = new MostWater();
        System.out.println(mostWater.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
