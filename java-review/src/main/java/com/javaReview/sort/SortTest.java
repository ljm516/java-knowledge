package com.javaReview.sort;

import java.beans.Statement;

/**
 * Created by jiangmingli on 2017/11/1.
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 6, 1, 5, 4, 0, 7};
        bubble_sort(arr);
        System.out.println();
        quick_sort(arr);
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        System.out.println(binarySearcher(arr, 4));
    }

    // 二分查找
    public static int binarySearcher(int[] arr, int k) {
        int low = 0, mid = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] < k) {
                low = mid + 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            }
        }
        return mid;
    }

    // 冒泡排序
    public static void bubble_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int k = 0; k <= arr.length-1; k++){
            System.out.print(arr[k] + " ");
        }
    }

    // 快速排序
    public static void quick_sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        int tmp = arr[low];

        while (low != high) {
            while (tmp <= arr[high] && low < high) {
                high --;
            }
            while (tmp >= arr[low] && low < high) {
                low ++;
            }
            if (low < high) {
                int t = arr[low];
                arr[low] = arr[high];
                arr[high] = t;
            }
        }
        for (int k = 0; k <= arr.length-1; k++){
            System.out.print(arr[k] + " ");
        }
    }
}
