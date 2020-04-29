package top.ljming.learning.indepth.dsa.lesson.geekbang;

/**
 * 在一个非负整数 a 中，我们希望从中移除 k 个数字，让剩下的数字值最小，如何选择移除哪 k 个数字呢？.
 *
 * @author lijm
 */
public class RemainMin {

    public long[] removeKNums(long nums, int k) {
        long r[] = new long[k];
        while (k > 0) {
            long yu = 0;
            int divTime = 0;
            while (nums >= 100) {
                yu += (nums % 10) * Math.pow(10, divTime);
                nums = nums / 10;
                divTime++;
            }
            long hi = nums / 10;
            long lo = nums % 10;

            if (hi > lo) { // 移除高位
                nums = (long) (lo * Math.pow(10, divTime) + yu);
                r[k - 1] = hi;
            } else {
                nums = (long) (hi * Math.pow(10, divTime) + yu);
                r[k - 1] = lo;
            }
            k--;
        }
        System.out.println(nums);
        return r;
    }

    public int minPathSum(int[][] grid) {
        return cal(grid, 0, 0);
    }

    public int cal(int[][] grid, int row, int col) {
        if (row == grid.length || col == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        return grid[row][col] + Math.min(cal(grid, row + 1, col), cal(grid, row, col + 1));
    }

    public static void main(String[] args) {
        RemainMin remainMin = new RemainMin();
//        long[] r = remainMin.removeKNums(4556847594546L, 5);
//        for (long i : r) {
//            System.out.println(i);
//        }

        int[][] in = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        remainMin.minPathSum(in);

    }
}
