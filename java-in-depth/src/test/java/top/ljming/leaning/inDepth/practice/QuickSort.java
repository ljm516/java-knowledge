package top.ljming.leaning.inDepth.practice;

import org.junit.Test;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class QuickSort {

    @Test
    public void test() {
        int[] arr = new int[]{9, 5, 4, 6, 8, 7, 3, 1, 2};
        int left = 0;
        int right = arr.length - 1;

        arr = sort(arr, left, right);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public int[] sort(int arr[], int left, int right) {
        if (left < right) {
            int partitionIdex = partition(arr, left, right);
            sort(arr, left, partitionIdex - 1);
            sort(arr, partitionIdex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;

    }

    private void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
