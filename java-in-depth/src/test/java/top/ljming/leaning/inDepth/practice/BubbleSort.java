package top.ljming.leaning.inDepth.practice;

import org.junit.Test;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BubbleSort {

    @Test
    public void sort() {
        int[] arr = new int[]{9, 5, 4, 6, 8, 7, 3, 1, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + "，");
        }
    }
}
