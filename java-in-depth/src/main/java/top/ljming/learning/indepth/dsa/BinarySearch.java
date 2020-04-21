package top.ljming.learning.indepth.dsa;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BinarySearch {

    /**
     * 二分查找.
     *
     * @param arr arr
     * @param n   n
     * @return boolean
     */
    public static boolean findN(int[] arr, int n) {
        int mid, low = 0, high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == n) {
                return true;
            }
            if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    /**
     * 二分查找的变种
     * <p>
     * LeetCode 第 33 题，给定一个经过旋转了的排序数组，判断一下某个数是否在里面。
     * 示例：给定数组为 {4, 5, 6, 7, 0, 1, 2}，target 等于 0，答案是 4，即 0 所在的位置下标是 4。
     *
     * @param nums   arr
     * @param target n
     * @return boolean
     */
    public int findInReversedArr(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) { // 判断左半边是不是排好序的
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int findFirstBiggerTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }


            if (nums[mid] > target) {
                if (nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long num;
        int mid, lo = 2, hi = x / 2;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            num = (long) mid * mid;
            if (num == x) {
                return mid;
            }
            if (num > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
//        int arr[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
//        System.out.println(bs.findFirstBiggerTarget(arr, 6));

        System.out.println(bs.mySqrt(9));
    }
}
