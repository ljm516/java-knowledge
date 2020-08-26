package top.ljming.javaindepth.dsa.leetcode;

import top.ljming.javaindepth.dsa.sort.BinarySearch;
import top.ljming.javaindepth.dsa.sort.InsertSort;

/**
 * 给出n个数的数组，返回不在数组中的最小正整数.
 * eg:
 * [1,2,3] -> 4
 * [-1,-3] -> 1
 * [1,3,6,4,1,2] -> 5
 *
 * @author lijm
 */
public class SmallestPositiveInteger {

    private static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        if (arr.length == 1) {
            int n = arr[0];
            if (n < 0) {
                return 1;
            } else {
                return n + 1;
            }
        }
        int[] sortArr = InsertSort.sort(arr);
        // 最小的正整数为1，先判断1在不在，不在就完事儿了
        if (!BinarySearch.findN(sortArr, 1)) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n <= 0) {
                continue;
            }
            int temp = n + 1;
            if (!BinarySearch.findN(sortArr, temp) && min > temp) {
                min = temp;
            }
        }
        if (min <= 0 || min == Integer.MAX_VALUE) {
            min = 1;
        }
        return min;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4};
        System.out.println(solution(arr));
    }

}
