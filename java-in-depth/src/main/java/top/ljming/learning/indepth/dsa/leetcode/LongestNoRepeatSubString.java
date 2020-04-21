package top.ljming.learning.indepth.dsa.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长无重复子串.
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author lijm
 */
public class LongestNoRepeatSubString {

    private int solution(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        // 用快慢指针i和j扫描一遍字符串，如果快指针所指向的字符已经出现在set集合里，则将慢指针所指向的字符从set集合中删除
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            // 将快指针指向的字符放入到set集合，更新max的值。
            set.add(s.charAt(j));
            max = Math.max(max, set.size());
        }

        return max;
    }

    public static void main(String[] args) {
        LongestNoRepeatSubString lnrss = new LongestNoRepeatSubString();
        System.out.println(lnrss.solution("abcabcbb"));
    }
}
