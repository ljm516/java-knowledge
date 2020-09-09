package top.ljming.javaindepth.dsa.leetcode;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class RevertMatrix {

    public int[][] func(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] r = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                r[j][i] = A[i][j];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        RevertMatrix rm = new RevertMatrix();
        int[][] A = new int[][] {{1, 2, 3}, {4, 5, 6}};
        int[][] r = rm.func(A);
        for (int[] ints : r) {
            for (int j = 0; j < r[0].length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }
}
