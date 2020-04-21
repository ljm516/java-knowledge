package top.ljming.learning.indepth.dsa.lesson.geekbang;

/**
 * 0-1背包问题.
 *
 * @author lijm
 */
public class PackageProblem {

    int maxW = Integer.MIN_VALUE;
    int w = 9; // 背包最大承重
    int n = 5; // 物品个数
    int[] weight = new int[]{2, 2, 4, 6, 3}; // 物品重量


    boolean[][] mem = new boolean[5][10]; // 记录递归节点是否已经处理过

    /**
     * 基本的回溯思想，使用递归的方式，枚举每种可能.
     *
     * @param i i
     * @param cw cw
     * @return int
     */
    private int huisu(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return cw;
        }
        if (cw + weight[i] <= w) {
            return huisu(i + 1, cw + weight[i]); // 选择装第i个物品
        }
        return huisu(i + 1, cw); // 选择不装
    }

    /**
     * 回溯的思想.
     *
     * 在基础的回溯思想上做了优化，是用一个容器保存已经处理过的状态.
     *
     * @param i i
     * @param cw cw
     * @return int
     */
    private int huisu_op(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return cw;
        }
        if (mem[i][cw]) {
            return cw;
        }
        mem[i][cw] = true;
        if (cw + weight[i] <= w) {
            return huisu(i + 1, cw + weight[i]); // 选择装第i个物品
        }
        return huisu(i + 1, cw); // 选择不装
    }

    /**
     * 使用动态规划的思想.
     *
     * @param weight weight
     * @param n i
     * @param w w
     * @return int
     */
    private int dtgh(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; i <= w; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                return i;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        PackageProblem pp = new PackageProblem();
        System.out.println(pp.huisu(0, 0));
        System.out.println(": time " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(pp.huisu_op(0, 0));
        System.out.println(": time " + (System.currentTimeMillis() - start));
    }
}
