package top.ljming.learning.indepth.dsa.ms;

/**
 * 游戏币的组合. 智线
 *
 * 小明的抽屉里有n个游戏币，总⾯值m，游戏币的设置有1分的，2分的，5分的，10分的，
 * ⽽在小明所拥有的游戏币中有些面值的游戏币可能没有，求⼀共有多少种可能的游戏币组合方式?
 * 输入: 两个数n(游戏币的个数)，m(总⾯面值)。
 * 输出: 请输出可能的组合方式数
 * @author lijm
 */
public class GameCoinCombination {
    public static void main(String[] args) {
        int n = 4;
        int m = 18;
        int value[] = new int[]{1, 2, 5, 10};

    }

    private static int combination(int[] value, int n, int m) {
        if (n == 0 || m == 0 || value == null || value.length == 0) {
            return 0;
        }
        if (n * 10 < m) {
            return 0;
        }
        int numOf10 = 0;

        while (m > 0) {

        }
        for (int i = 0; i < value.length; i++) {
            int v = value[i];
            int total = 0;
            for (int num = 0; num < n; num++) {

            }
        }
        return 0;
    }

}
