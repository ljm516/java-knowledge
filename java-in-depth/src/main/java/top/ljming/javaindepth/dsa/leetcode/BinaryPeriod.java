package top.ljming.javaindepth.dsa.leetcode;

/**
 * 给出一个正整数，求出这个数的二进制循环周期是多少?
 * eg:
 * 955的二进制是 1101 1101 11，则周期为4
 *
 * @author lijm
 */
public class BinaryPeriod {

   static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok && p != l) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(955));
    }
}
