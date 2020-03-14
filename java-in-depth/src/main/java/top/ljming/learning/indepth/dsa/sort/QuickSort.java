package top.ljming.learning.indepth.dsa.sort;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class QuickSort {


    public static void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int start, int end) {

        int pivotIndex = getPivotIndex(arr, start, end);
        doSort(arr, start, pivotIndex - 1);
        doSort(arr, pivotIndex + 1, end);

    }

    private static int getPivotIndex(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            // 当队尾的元素大于等于基准数据时，向前移动end指针
            while (start < end && arr[end] >= pivot) {
                end--;
            }
            arr[start] = arr[end];
            // 当队首元素小于等于基准数据时，向后移动start指针
            while (start < end && arr[start] <= pivot) {
                start++;
            }
            // 当队首元素大于temp时，需要将其赋值给high
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 5, 4, 6, 8, 7, 3, 1, 2};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + "，");
        }
    }
}
