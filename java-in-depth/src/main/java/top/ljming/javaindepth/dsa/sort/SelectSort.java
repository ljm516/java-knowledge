package top.ljming.javaindepth.dsa.sort;

/**
 * 选择排序，每次从需要排序的数组里选择最小的.
 *
 * @author lijm
 */
public class SelectSort {

    /**
     * 算法步骤:
     * 1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     * 3. 重复第二步，直到所有元素均排序完成.
     *
     * @param arr 未排序的数组
     */
    public static void sort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) { // 找出最小值
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
