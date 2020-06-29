package top.ljming.learning.indepth.dsa;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class Ms {


    public int find(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                hi = mid - 1;
            }
            if (arr[mid] < target) {
                lo = mid + 1;
            }
        }

        return -1;
    }

}
