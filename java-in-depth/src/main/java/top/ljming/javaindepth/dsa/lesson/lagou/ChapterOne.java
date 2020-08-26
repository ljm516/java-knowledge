package top.ljming.javaindepth.dsa.lesson.lagou;

import java.util.HashMap;
import java.util.Map;

/**
 * 常用数据结构.
 *
 * @author ljming
 */
public class ChapterOne {

    public static void main(String[] args) {
        ChapterOne chapterOne = new ChapterOne();
        System.out.println(chapterOne.leetCode242Advance("a", "ab"));
    }

    /**
     * stupid方法.
     *
     * @param s s
     * @param t t
     * @return boolean
     */
    public boolean leetCode242Stupid(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Map<Character, Integer> ct = new HashMap<>(16);
        for (char c : sc) {
            if (ct.containsKey(c)) {
                ct.put(c, ct.get(c) + 1);
            } else {
                ct.put(c, 1);
            }
        }
        for (char c : tc) {
            if (ct.containsKey(c)) {
                ct.put(c, ct.get(c) - 1);
            }
        }
        for (Integer v : ct.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 高级方法. 使用数据保存每个字母出现的次数，第一个字符串的字母出现次数++。第二个字符串的字母--
     *
     * @param s s
     * @param t t
     * @return boolean
     */
    public boolean leetCode242Advance(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
