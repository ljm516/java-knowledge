package top.ljming.javaindepth.dsa.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 排序的练习.
 *
 * @author lijm
 */
public class SortExercise {

    /**
     * 冒泡排序.
     *
     * @param arr 原数组
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) { // 第一层控制冒泡次数
            boolean hasChange = false;
            for (int j = 1; j < arr.length; j++) { // 第二层进行数据交换
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j - 1] = temp;

                    hasChange = true;
                }
            }
            if (!hasChange) {
                break;
            }
        }
    }

    /**
     * 选择排序.
     *
     * @param arr 原数组
     */
    public void selectSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) { // 选择当前元素为最小元素
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) { // 从为排序的序列中找到真正最小的元素，并交换
                if (min > arr[j]) {
                    int temp = min;
                    min = arr[j];
                    arr[j] = temp;
                }
            }
            arr[i] = min;
        }
    }

    /**
     * 插入排序.
     *
     * @param arr 原数组
     */
    public void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) { // 未排序的序列，从第二个元素开始
            int curr = arr[i];
            int preIdx = i - 1;
            while (preIdx >= 0 && arr[preIdx] > curr) { // 不断往前找，找到curr可以插入的位置
                arr[preIdx + 1] = arr[preIdx]; // 元素往后挪
                preIdx--;
            }
            arr[preIdx + 1] = curr;
        }

    }

    /**
     * 归并排序. 递归的思想
     *
     * @param arr 原数组
     */
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
//        int l = 0;
//        int r = arr.length - 1;
//        int mid =
    }


    public void heapSort(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for(int a : arr) {
            queue.offer(a);
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            arr[idx] = queue.poll();
            idx++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 6, 3, 2, 1};

        SortExercise exercise = new SortExercise();
        exercise.heapSort(arr);

        for (int a : arr) {
            System.out.print(a + ",");
        }
    }
}
