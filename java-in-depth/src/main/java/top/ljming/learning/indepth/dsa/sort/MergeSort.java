package top.ljming.learning.indepth.dsa.sort;

/**
 * 合并排序.
 *
 * @author lijm
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 7, 9, 5, 8};
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
        int[] copy = arr.clone();

        // k表示从什么位置开始修改原数组，i指针表示左半边的起始位置，j表示右半边的起始位置
        int k = left, i = left, j = mid + 1;

        while (k <= right) {
            if (i > mid) { // i 表示数组左边开始下标，这里说明左边的数据都ok了，则将右边的数据拷贝过去
                arr[k++] = copy[j++];
            } else if (j > right) { // j 表示数组左边开始下标，这里说明右边的数据都ok了，则将左边的数据拷贝过去
                arr[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                arr[k++] = copy[j++];
            } else {
                arr[k++] = copy[i++];
            }
        }
    }
}
