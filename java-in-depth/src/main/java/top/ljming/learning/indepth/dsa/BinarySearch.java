package top.ljming.learning.indepth.dsa;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BinarySearch {

    public static boolean findN(int[] arr, int n) {
        int mid, low = 0, high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == n) {
                return true;
            }
            if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
