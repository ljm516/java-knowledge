package top.ljming.learning.indepth.dsa.leetcode;

import top.ljming.learning.indepth.dsa.domain.Tree;

/**
 * 二叉树的最大深度.
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author lijm
 */
public class BiggestTreeDepth {

    public int maxDepth(Tree root) {
        if (null == root) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        BiggestTreeDepth bgd = new BiggestTreeDepth();


        Tree one = new Tree(null, null, 1);
        Tree two = new Tree(null, null, 2);
        Tree tree = new Tree(one, two, 3);
        Tree four = new Tree(null, null, 4);

        Tree root = new Tree(four, tree, 5);

        System.out.println(bgd.maxDepth(root));
    }

}
