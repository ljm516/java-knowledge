package top.ljming.learning.indepth.dsa.ms;

import top.ljming.learning.indepth.dsa.domain.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class BTree {

    public static void main(String[] args) {
        BTree bTree = new BTree();

        Tree one = new Tree(null, null, 1);
        Tree two = new Tree(null, null, 2);
        Tree tree = new Tree(one, two, 3);
        Tree four = new Tree(null, null, 4);

        Tree root = new Tree(four, tree, 5);

        bTree.backTraversal(root, new ArrayList<>());
    }

    /**
     * 二叉树的前序遍历.
     *
     * 1. 先访问根节点
     * 2. 再遍历左子树
     * 3. 最后遍历右子树
     * @param root
     * @param res
     */
    public void frontTraversal(Tree root, List<Integer> res) {
        if (root != null) {
            res.add(root.value);
            frontTraversal(root.left, res);
            frontTraversal(root.right, res);
        }
        System.out.println(res);
    }

    /**
     * 二叉树的中序遍历.
     *
     * 1. 先中序遍历左子树
     * 2. 再访问根节点
     * 3. 最后中序遍历右子树
     * @param root
     */
    public void midTraversal(Tree root, List<Integer> res) {
        if (root != null) {
            midTraversal(root.left, res);
            res.add(root.value);
            midTraversal(root.right, res);
        }
        System.out.println(res);
    }

    /**
     * 二叉树的后序遍历.
     *
     * 1. 先后序遍历左子树.
     * 2. 再后序遍历右子树.
     * 3. 最后访问根节点.
     *
     * @param root
     * @param res
     */
    public void backTraversal(Tree root, List<Integer> res) {
        if (root != null) {
            backTraversal(root.left, res);
            backTraversal(root.right, res);
            res.add(root.value);
        }
        System.out.println(res);
    }

    // 层序遍历
    public void levelTraversal(Tree root) {
        LinkedList<Tree> treeList = new LinkedList<>();
        treeList.offer(root);

        while (!treeList.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = treeList.size();
            while (size > 0) {
                Tree t = treeList.poll();
                level.add(t.value);
                if (t.left != null) {
                    treeList.offer(t.left);
                }
                if (t.right != null) {
                    treeList.offer(t.right);
                }
                size--;
            }
            System.out.println(level);
        }
    }
}
