package top.ljming.javaindepth.dsa.leetcode;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class LongestCommonPre {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(func(new String[] {"dog","dogooos","doddd"}));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static String func(String[] strs) {
        int len = strs[0].length();
        String longestPre;
        String res = "";
        for (int i = 0; i < len; i++) {
            longestPre = strs[0].substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(longestPre)) {
                    return res;
                }
            }
            res = longestPre;
        }
        return res;
    }
}
