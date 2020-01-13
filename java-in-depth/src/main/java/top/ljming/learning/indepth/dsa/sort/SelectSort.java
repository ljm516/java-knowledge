package top.ljming.learning.indepth.dsa.sort;

/**
 * 选择排序，每次从需要排序的数组里选择最小的.
 *
 * @author lijm
 */
public class SelectSort {

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
