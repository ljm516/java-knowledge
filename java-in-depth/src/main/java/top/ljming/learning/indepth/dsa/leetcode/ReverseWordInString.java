package top.ljming.learning.indepth.dsa.leetcode;

/**
 * 翻转字符串里的单词.
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author lijm
 */
public class ReverseWordInString {

    public String reverseWords(String s) {

        s= s.trim();

        String[] words = s.split(" ");

        for (int i = 0; i < words.length / 2; i++) {
            String tem = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = tem;
        }
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!"".equals(w)) {
                sb.append(w).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordInString rwis = new ReverseWordInString();
        System.out.println(rwis.reverseWords("a good   example"));
    }
}
