package top.ljming.javaindepth.dsa.leetcode;

/**
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。.
 *
 * @author lijm
 */
public class HappyNum {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static boolean isHappy(int n) {
        int loop = 0;
        while (n != 1 && loop < 1000) {
            n = sum(n);
            if (n == 1) {
                return true;
            }
            loop++;
        }
        return false;
    }

    private static int sum(int n) {
        int yushu = n % 10;
        int shang = n / 10;
        int sum = yushu * yushu;
        while (shang != 0) {
            yushu = shang % 10;
            shang = shang / 10;
            sum += yushu * yushu;
        }
        return sum;
    }

}
