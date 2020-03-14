package top.ljming.leaning.inDepth.practice;

import org.junit.Test;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class SelectSort {

    @Test
    public void sort() {
        int[] arr = new int[]{9, 5, 4, 6, 8, 7, 3, 1, 2};
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i: arr) {
            System.out.print(i + ",");
        }
    }
}
