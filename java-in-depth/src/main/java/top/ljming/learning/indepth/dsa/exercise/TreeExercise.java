package top.ljming.learning.indepth.dsa.exercise;

import top.ljming.learning.indepth.dsa.domain.Tree;

import java.util.LinkedList;

/**
 * 二叉树的练习.
 *
 * @author lijm
 */
public class TreeExercise {

    // 二叉查找树，在树的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树的值都要大于这个节点的值

    // 前序遍历 根 -> 左子树 -> 右子树
    public void frontTraversal(Tree root) {
        if (null == root) {
            return;
        }
        System.out.println(root.value);
        if (null != root.left) {
            frontTraversal(root.left);
        }
        if (null != root.right) {
            frontTraversal(root.right);
        }
    }

    // 中序遍历  左子树 -> 根 -> 右子树
    public void midTraversal(Tree root) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            midTraversal(root.left);
        }
        System.out.println(root.value);
        if (null != root.right) {
            midTraversal(root.right);
        }
    }

    // 后序遍历 左子树 -> 右子树 -> 根
    public void backTraversal(Tree root) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            backTraversal(root.left);
        }
        if (null != root.right) {
            backTraversal(root.right);
        }
        System.out.println(root.value);
    }

    // 层序遍历 按树的层级访问
    public void floorTraversal(Tree root) {
        if (null == root) {
            return;
        }
        LinkedList<Tree> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Tree t = queue.poll();
            System.out.println(t.value);
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeExercise exercise = new TreeExercise();
        Tree one = new Tree(null, null, 1);
        Tree two = new Tree(null, null, 2);
        Tree tree = new Tree(one, two, 3);
        Tree four = new Tree(null, null, 4);

        Tree root = new Tree(four, tree, 5);

        exercise.frontTraversal(root);
        System.out.println();
        exercise.midTraversal(root);
        System.out.println();
        exercise.backTraversal(root);
        System.out.println();
        exercise.floorTraversal(root);
    }
}
