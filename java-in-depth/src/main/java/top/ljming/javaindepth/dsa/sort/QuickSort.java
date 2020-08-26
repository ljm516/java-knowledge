package top.ljming.javaindepth.dsa.sort;

/**
 * 快排.
 *
 * @author lijm
 */
public class QuickSort {

    public int[] sort(int[] nums) {
        return doSort(nums, 0, nums.length - 1);
    }

    private int[] doSort(int[] nums, int l, int r) {
        // 完成排序的依据
        if (l >= r) {
            return nums;
        }
        // 算出pivot的下标，作为左右子序列排序的下标
        int pivotIdx = getPivotIdx(nums, l, r);
        doSort(nums, l, pivotIdx - 1);
        doSort(nums, pivotIdx + 1, r);
        return nums;
    }

    private int getPivotIdx(int[] nums, int l, int r) {
        // 选择最左边的为基准
        int pivot = nums[l];
        while (l < r) {
            // 不断移动右下标，如果当前下标值小于pivot基准值，跳出循环，把该值放到pivot的左边
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            // 不断移动左下标，如果当前下标值大于pivot基准值，跳出循环，把该值放到pivot的右边
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        // 整个循环结束，l=r，将pivot的值放入该下标
        nums[l] = pivot;
        return l;


    }
}
