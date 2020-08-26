/**
 * 描述类的功能.
 *
 * @author ljming
 */
package top.ljming.javaindepth.dsa.ms;

import top.ljming.javaindepth.dsa.domain.Tree;

/**
 * 字节跳动算法题.
 *
 * @author ljming
 */
public class ByteDance {
    int result = 1;

    /**
     * 抖音商业化
     * 1. 二叉树的两节点最远距离
     * 2. 字符串做减法，例如："321" - "111" = "210"
     */

    /**
     * 1面.
     *
     * @param root root
     * @return int
     */
    public int longestDisInTree(Tree root) {
        longestDis(root);
        return result - 1;
    }

    public int longestDis(Tree root) {
        if (root == null) {
            return 0;
        }
        int leftDis = longestDis(root.left);
        int rightDis = longestDis(root.right);

        result = Math.max(result, leftDis + rightDis + 1);

        return Math.max(leftDis, rightDis) + 1;
    }

    public static void main(String[] args) {
        ByteDance bd = new ByteDance();
//        Tree one = new Tree(null, null, 1);
//        Tree two = new Tree(null, null, 2);
//        Tree tree = new Tree(one, two, 3);
//        Tree four = new Tree(null, null, 4);
//
//        Tree root = new Tree(four, tree, 5);
//
//        int result = 0;
//
//        System.out.println(bd.longestDisInTree(root));

        System.out.println(bd.stringSubtraction("1000", "9"));
    }

    /**
     * 二面.
     *
     * @param s1 s1
     * @param s2 s2
     * @return string
     */
    public String stringSubtraction(String s1, String s2) {
        if (null == s1) {
            return s2;
        }
        if (s2 == null) {
            return s1;
        }
        String[] sa1 = s1.split("");
        String[] sa2 = s2.split("");

        int len1 = sa1.length - 1;
        int len2 = sa2.length - 1;
        String result = "";
        while (len1 >= 0 && len2 >= 0) {
            String c1 = sa1[len1];
            String c2 = sa2[len2];

            int c1v = Integer.parseInt(c1);
            int c2v = Integer.parseInt(c2);
            if (c1v < c2v) {
                int start = len1 - 1;
                int sv;
                while (start >= 0 && (sv = Integer.parseInt(sa1[start]) - 1) <= 0) {
                    sa1[start] = sv + "";
                    start--;
                }
                c1v += 10;

                result += c1v - c2v;

                len1--;
                len2--;
            }
        }
        while (len1 >= 0) {
            if (len1 == 0 && sa1[len1].equals("0")) {
                continue;
            }
            int v = Integer.parseInt(sa1[len1]);
            if (v < 0) {
                int start = len1;
                int sv;
                while (start >= 0 && (sv = Integer.parseInt(sa1[start])) <= 0) {
                    sa1[start] = sv + "";
                    start--;
                }
                v += 10;
            }
            result = v + result;
            len1--;
        }
        return result;
    }
}
