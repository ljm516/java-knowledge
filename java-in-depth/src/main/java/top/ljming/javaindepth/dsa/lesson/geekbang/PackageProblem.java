package top.ljming.javaindepth.dsa.lesson.geekbang;

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

    int maxV = Integer.MIN_VALUE;


    boolean[][] mem = new boolean[5][10]; // 记录递归节点是否已经处理过

    /**
     * 基本的回溯思想，使用递归的方式，枚举每种可能.
     *
     * @param i  i
     * @param cw cw
     * @return int
     */
    private int huisu(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return maxW;
        }
        if (cw + weight[i] <= w) {
            return huisu(i + 1, cw + weight[i]); // 选择装第i个物品
        }
        return huisu(i + 1, cw); // 选择不装
    }

    /**
     * 回溯的思想.
     * <p>
     * 在基础的回溯思想上做了优化，是用一个容器保存已经处理过的状态.
     *
     * @param i  i
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
     * @param n      i
     * @param w      w
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

    /**
     * 0-1背包问题的升级，在满足背包最大重量的前提下，求可装入物品的最大价值.
     *
     * @param items 物品重量
     * @param itemV 物品价值
     * @param pw    背包承重
     * @param i 第几个物品
     * @param cw 当前物品重量
     * @param cv 当前物品价值
     * @return 可装入的物品最大价值
     */
    public int maxValue(int items[], int[] itemV, int pw, int i, int cw, int cv) {
        if (i == items.length - 1 || cw == pw) {
            if (cv > maxV) {
                maxV = cv;
            }
            return cv;
        }
        maxValue(items, itemV, pw, i + 1, cw, cv);
        if (cw + items[i] <= pw) {
            maxValue(items, itemV, pw, i + 1, cw + items[i], cv + itemV[i]);
        }
        return maxV;
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
