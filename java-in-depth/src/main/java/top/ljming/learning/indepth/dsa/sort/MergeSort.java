package top.ljming.learning.indepth.dsa.sort;

/**
 * 合并排序.
 *
 * @author lijm
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    public static void sort(int[] arr, int left, int right) {
        if (left ==  right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }

        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}
