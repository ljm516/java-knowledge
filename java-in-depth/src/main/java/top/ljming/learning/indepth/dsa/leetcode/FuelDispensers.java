package top.ljming.learning.indepth.dsa.leetcode;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class FuelDispensers {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 8, 4, 3, 2}, 7, 11, 3));
    }

    static int solution(int[] A, int X, int Y, int Z) {
        int[] dispensers = new int[]{X, Y, Z};
        int[] d_pre = new int[dispensers.length];

        for (int idx = 0; idx < A.length; idx++) {
            int d_idx = idx;
            if (d_idx > dispensers.length - 1) {
                d_idx = 0;
            }
            if (dispensers[d_idx] >= A[idx]) {
                d_pre[d_idx] += A[idx];
                dispensers[d_idx] = dispensers[d_idx] - A[idx];
            }
        }

        return -1;
    }

}
