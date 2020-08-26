package top.ljming.javaindepth.dsa.leetcode;

import top.ljming.javaindepth.dsa.domain.Tree;

/**
 * 二叉树的翻转.
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/submissions/
 * @author lijm
 */
public class TreeReverse {

    public Tree invert(Tree root) {
        if (root == null) {
            return null;
        }
        Tree left = root.left;

        root.left = root.right;
        root.right = left;

        invert(root.left);
        invert(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeReverse tr = new TreeReverse();

        Tree one = new Tree(null, null, 1);
        Tree two = new Tree(null, null, 2);
        Tree tree = new Tree(one, two, 3);
        Tree four = new Tree(null, null, 4);

        Tree root = new Tree(four, tree, 5);

        root = tr.invert(root);
        System.out.println(root.value);
    }
}
