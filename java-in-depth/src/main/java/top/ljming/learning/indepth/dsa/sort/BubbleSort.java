package top.ljming.learning.indepth.dsa.sort;

/**
 * 冒泡排序: 从数组最后面开始循环，如果一个数比前面的小，则交换位置.
 * 算法步骤:
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对，这步做完，最后的元素会是最大的数。
 * 3. 针对所有的元素重复以上的步骤，除了最后一个。
 * 4. 持续每次越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 *
 * @author lijm
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int idx = 0; idx < arr.length - 1; idx++) { // 需要进行排序的次数
            for (int j = 1; j < arr.length; j++) { // 将相邻两个数进行交换
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void sortOptimiz(int[] arr) {
        for (int idx = 0; idx < arr.length - 1; idx++) { // 需要进行排序的次数
            boolean hasChange = false; // 定义一个标志，标记当前是否发生交换，如果没有发生交换，说明当前序列是有序，那么就不需要再执行冒泡操作
            for (int j = 1; j < arr.length; j++) { // 将相邻两个数进行交换
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    hasChange = true;
                }
            }
            if (!hasChange) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        sortOptimiz(arr);
        for (int a: arr) {
            System.out.println(a);
        }
    }
}
