package top.ljming.learning.indepth.dsa.sort;

/**
 * 冒泡排序: 从数组最后面开始循环，如果一个数比前面的小，则交换位置.
 *
 * @author lijm
 */
public class BubbleSort {

    /**
     * 正序.
     *
     * @param arr arr
     */
    public static void ascSort(int[] arr) {
        for (int idx = 0; idx < arr.length - 1; idx++) {
            for (int j = arr.length - 1; j > idx; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 倒序.
     *
     * @param arr arr
     */
    public static void descSort(int[] arr) {
        for (int idx = 0; idx < arr.length - 1; idx++) {
            for (int j = arr.length - 1; j > idx; j--) {
                if (arr[j - 1] < arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void sort(int[] arr) {
        for (int idx = 0; idx < arr.length - 1; idx++) { // 需要进行排序的次数
            for (int j = idx + 1; j < arr.length; j++) { // 将相邻两个数进行交换
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
