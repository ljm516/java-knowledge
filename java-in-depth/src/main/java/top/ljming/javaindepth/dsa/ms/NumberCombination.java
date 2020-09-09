package top.ljming.javaindepth.dsa.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * 给点一个整数数组，返回所有元素的全排列组合.
 * [1,2,3] —> [123, 132, 213, 231, 321, 312]
 *
 * @author ljming
 */
public class NumberCombination {

    List<Integer> resultList = new ArrayList<>();

    public List<Integer> func(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            resultList.add(nums[0]);
        } else {

        }
        return resultList;
    }

    public List<String[]> combination(int i, List<String[]> subList) {
        List<String[]> newSubList = new ArrayList<>();
        if (null == subList) {
            newSubList.add(new String[]{i + ""});
            return newSubList;
        }
        for (String[] combination : subList) {
            for (String s : combination) {
                String[] subArr = s.split("");
                for (int idx = 0; idx < subArr.length; idx++) {
                    String[] reArr = new String[subArr.length + 1];
                    reArr[idx] = String.valueOf(i);
                    for (int j = 0; j < reArr.length; j++) {
                        if (j == idx) {
                            continue;
                        }
                        reArr[j] = subArr[idx];
                    }
                    newSubList.add(reArr);
                }
            }
        }
        return newSubList;
    }

    public static void main(String[] args) {
        NumberCombination combination = new NumberCombination();
        List<String[]> subList = combination.combination(1, null);
        subList = combination.combination(2, subList);

    }

}
