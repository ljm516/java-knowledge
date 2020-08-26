package top.ljming.javaindepth.dsa.ms;

/**
 * 邀请码检测. 【智线】
 * 某产品的⽤用户注册邀请码为⼀一串串有⼩小写字⺟母和数字组成的字符串串，字符串串⻓长度为16。当⽤用户数据邀 请码的时候，
 * 系统需要对邀请码做有效性验证，假设验证规则如下:
 * 1、从序列列号最后⼀一位字符开始，逆向将奇数位(1、3、5等等)相加;
 * 2、从序列列号最后⼀一位数字开始，逆向将偶数位数字，先乘以2(如果乘积为两位数，则将其减去 9)，再求和;
 * 3、将奇数位总和加上偶数位总和，结果可以被10整除;
 * 4、⼩写字⺟对应数值，可由下⾯面键值对确定;
 * [(a,1), (b,2), (c,3)...,(i,9), (j,1), (k, 2)...]，亦即，按字⺟母顺序，1-9循环。
 * 输⼊入:输⼊入16位字符串串，表示邀请码 输出:输出“ok”或者“error”
 *
 * @author lijm
 */
public class VerifyCodeCheck {

    public static void main(String[] args) {
        String verifyCode = "ab1n45l69mn793u4";
        System.out.println(check(verifyCode));
    }

    private static String check(String verifyCode) {
        if (null == verifyCode || verifyCode.length() == 0) {
            return "error";
        }
        char[] code = verifyCode.toCharArray();
        int oddSum = 0; // 奇数位和
        int evenSum = 0; // 偶数位和
        int idxValue = 0;
        int mod;
        for (int i = code.length - 1; i >= 0; i--) {
            mod = (code[i] + 2) / 10;
            if ((i + 1) % 2 == 0) { // 偶数位
                if (mod == 5) { // 数字0-9
                    idxValue = (code[i] + 2) % 10;
                    if (idxValue > 10) {
                        idxValue = idxValue - 9;
                    }
                    evenSum += idxValue;
                }
            } else {
                if (mod == 5) { // 数字0-9
                    idxValue = (code[i] + 2) % 10;
                } else { // 字母a-z
                    idxValue = ((code[i] + 2) % 9) + 1;
                }
                oddSum += idxValue;
            }
        }
        System.out.println((oddSum + evenSum));
        if ((oddSum + evenSum) % 10 != 0) {
            return "error";
        }
        return "ok";
    }
}
