package top.ljming.javaindepth.dsa.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 数组知识点.
 *
 * @author lijm
 */
public class ArrayExercise {

    private int[] table;

    private static final int defaultCap = 10;

    private int count = 0;

    private ArrayExercise() {
        this(defaultCap);
    }

    private ArrayExercise(int cap) {
        this.table = new int[cap];
    }

    // 添加元素
    public void add(int num) {
        if (++count > table.length) { // 如果新增元素后，个数超过数组容量，则进行扩容
            resize();
        }
        table[count - 1] = num;
    }

    // 移除一个元素
    private int remove(int idx) {
        if (idx < 0 || idx >= table.length) {
            throw new ArrayIndexOutOfBoundsException(-1);
        }
        int num = table[idx];
        for (int i = idx; i < table.length; i++) {
            if (i + 1 == table.length) {
                table[i] = 0;
            } else {
                table[i] = table[i + 1];
            }
        }
        count--;
        return num;
    }

    // 更新
    private int update(int idx, int value) {
        if (idx < 0 || idx >= table.length) {
            throw new ArrayIndexOutOfBoundsException(-1);
        }
        int old = table[idx];
        table[idx] = value;
        return old;
    }

    // 扩容
    private void resize() {
        table = Arrays.copyOf(table, table.length << 1);
    }

    private int[] merge(int arr1[], int arr2[]) {
        if (null == arr1 || arr1.length == 0) {
            return arr2;
        }
        if (null == arr2 || arr2.length == 0) {
            return arr1;
        }
        int[] newArr = new int[arr1.length + arr2.length];

        int n = 0;
        int m = 0;
        while (n < arr1.length && m < arr2.length) {
            if (arr1[n] < arr2[m]) {
                newArr[n + m] = arr1[n];
                n++;
            } else {
                newArr[n + m] = arr2[m];
                m++;
            }
        }
        while (n < arr1.length) {
            newArr[n + m] = arr1[n];
            n++;
        }

        while (m < arr2.length) {
            newArr[n + m] = arr2[m];
            m++;
        }

        return newArr;
    }

    private int[] mergeKArr(List<int[]> arrays) {

        int totalLen = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] arr : arrays) {
            totalLen += arr.length;
            for (int n : arr) {
                queue.offer(n);
            }
        }
        int[] big = new int[totalLen];
        int idx = 0;
        while (!queue.isEmpty()) {
            big[idx] = queue.poll();
            idx++;
        }
        return big;
    }

    public static void main(String[] args) {
        ArrayExercise exercise = new ArrayExercise();
//        for (int i = 1; i <= 20; i++) {
//            exercise.add(i);
//        }
//
//        int num = exercise.remove(19);
//        System.out.println("remove: " + num);
//
//        int old = exercise.update(19, 30);
//        System.out.println("update: " + old);
//
//        for (int n : exercise.table) {
//            System.out.print(n + ",");
//        }
        int[] arr1 = new int[]{0, 2, 3, 4, 7, 9, 10};
        int[] arr2 = new int[]{1, 5, 6, 8};

        List<int[]> arrays = new ArrayList<>();
        arrays.add(arr1);
        arrays.add(arr2);

        int[] r = exercise.mergeKArr(arrays);
        for (int n : r) {
            System.out.print(n + ",");
        }
    }
}
