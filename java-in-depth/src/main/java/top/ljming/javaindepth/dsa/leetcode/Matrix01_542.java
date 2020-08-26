package top.ljming.javaindepth.dsa.leetcode;

/**
 * 01矩阵.
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * https://leetcode-cn.com/problems/01-matrix/
 *
 * @author lijm
 */
public class Matrix01_542 {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] r = new int[matrix.length][matrix[0].length];
        solution(matrix, r, 0, 0);

        return r;
    }

    private void solution(int[][] matrix, int[][] r, int x, int y) {
        if (x < 0 || y < 0) {
            return;
        }
        if (matrix[x][y] == 0) {
            r[x][y] = 0;
            return;
        }



    }
}

