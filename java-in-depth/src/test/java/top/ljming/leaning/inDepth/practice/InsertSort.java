package top.ljming.leaning.inDepth.practice;

import org.junit.Test;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class InsertSort {
    @Test
    public void test() {
        int[] arr = new int[]{9, 5, 4, 6, 8, 7, 3, 1, 2};
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1]; // 选择数组的第二个开始
            int preIndex = i;
            while (preIndex >= 0 && arr[preIndex] > current) { // 只要当前元素的前面元素比它大，就交换两者
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
