package top.ljming.learning.indepth.dsa.leetcode;

/**
 * 最长上升子序列.
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author lijm
 */
public class LongestIncreaseSubSequence_300 {

    int max = Integer.MIN_VALUE;

    public int solution(int[] nums, int n) {
        if (n <= 1) {
            return n;
        }
        int result = 0, maxEndingHere = 1;
        for (int i = 1; i < n; i++) {
            result = solution(nums, i);

            if (nums[i - 1] < nums[n - 1] && result + 1 > maxEndingHere) {
                maxEndingHere = result + 1;
            }
        }

        max = max < maxEndingHere ? maxEndingHere : max;

        return maxEndingHere;
    }

    public static void main(String[] args) {
        LongestIncreaseSubSequence_300 lis = new LongestIncreaseSubSequence_300();

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        lis.solution(nums, nums.length);
        System.out.println(lis.max);
    }

}
