package top.ljming.javaindepth.dsa.leetcode;

/**
 * 8. 字符串转换整数 (atoi).
 * <p>
 * leetcode: https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author lijm
 */
public class Atoi {

    public int atoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char c[] = str.toCharArray();
        int idx = 0;
        boolean negative = false;
        if (c[0] == '-') {
            negative = true;
            idx++;
        } else if (c[0] == '+') {
            idx++;
        } else if (!Character.isDigit(c[0])) {
            return 0;
        }
        int ans = 0;
        while (idx < c.length && Character.isDigit(c[idx])) {
            int digit = c[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi("  0000000000012345678"));
    }
}
