package top.ljming.learning.indepth.dsa.sort;

/**
 * 插入排序.
 *
 * @author lijm
 */
public class InsertSort {

    public static int[] sort(int[] arr) {
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1]; // 选择数组的第二个组开始
            int preIndex = i;
            while (preIndex >= 0 && arr[preIndex] > current) { // 只要当前元素的前面元素比它大，就交换两者
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
