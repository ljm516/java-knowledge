package top.ljming.learning.indepth.dsa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 翻转字符串里的单词.
 * <p>
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author lijm
 */
public class ReverseWordInString {

    public String reverseWords(String s) {

        s = s.trim();

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

    public String reverseLeftWords(String s, int n) {
        if (null == s || s.length() == 0) {
            return null;
        }
        char[] ch = s.toCharArray();
        int b = 0;
        int swap = 0;
        while (b < n) {
            int ls = b + n - swap;
            char c = ch[b];
            ch[b] = ch[ls];
            for (int i = ls; i < ch.length; i++) {
                if (i == ch.length - 1) {
                    ch[i] = c;
                } else {
                    ch[i] = ch[i + 1];
                }
            }
            b++;
            swap++;
        }
        return String.valueOf(ch);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        Deque<Integer> deque = new LinkedList<>();
        int res[] = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);

            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseWordInString rwis = new ReverseWordInString();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};

        System.out.println(rwis.maxSlidingWindow(arr, 3));


    }
}
