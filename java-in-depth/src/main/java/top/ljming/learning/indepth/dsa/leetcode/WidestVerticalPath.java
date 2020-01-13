package top.ljming.learning.indepth.dsa.leetcode;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class WidestVerticalPath {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 8, 7, 3, 4, 1, 8}));
    }

    static int solution(int[] X) {
        int current;
        for (int i = 0; i < X.length - 1; i++) {
            current = X[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && X[preIndex] > current) {
                X[preIndex + 1] = X[preIndex];
                preIndex--;
            }
            X[preIndex + 1] = current;
        }
        int widest = 0;
        for (int i = 0; i < X.length - 1; i++) {
            int temp = X[i + 1] - X[i];
            if (temp > widest) {
                widest = temp;
            }
        }

        return widest;
    }
}
