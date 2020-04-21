package top.ljming.learning.indepth.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class TargetCombination_39 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> solution(int[] nums, int target) {
        func(nums, target, 0, new ArrayList<>());
        return result;
    }

    private void func(int[] nums, int target, int start, List<Integer> solution) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            solution.add(nums[i]);
            func(nums, target - nums[i], i, solution);
            solution.remove(solution.size() - 1);
        }
    }

    public static void main(String[] args) {
        TargetCombination_39 tc = new TargetCombination_39();
        int[] nums = {2, 3, 6, 7};
        int target = 7;

        System.out.println(tc.solution(nums, target));
    }
}
