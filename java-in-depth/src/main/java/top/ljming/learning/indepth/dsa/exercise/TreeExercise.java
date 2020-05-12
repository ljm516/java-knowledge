package top.ljming.learning.indepth.dsa.exercise;


import top.ljming.learning.indepth.dsa.domain.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    // z形打印二叉树
    public void zTraversal(Tree root) {
        if (null == root) {
            return;
        }
        Stack<Tree> oddStack = new Stack<>(); // 奇数栈
        Stack<Tree> evenStack = new Stack<>(); // 偶数栈

        int level = 1;
        oddStack.push(root);

        Tree curr;

        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (level % 2 == 1) {
                while (!oddStack.isEmpty()) {
                    curr = oddStack.pop();
                    System.out.println(curr.value);
                    if (curr.left != null) {
                        evenStack.push(curr.left);
                    }
                    if (curr.right != null) {
                        evenStack.push(curr.right);
                    }
                }
            } else {
                while (!evenStack.empty()) {
                    curr = evenStack.pop();
                    System.out.println(curr.value);

                    if (curr.right != null) {
                        oddStack.push(curr.right);
                    }
                    if (curr.left != null) {
                        evenStack.push(curr.left);
                    }
                }
            }
            level++;
        }
    }

    public boolean isSymmetryTree(Tree root) {
        if (null == root) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        specMidTraversal(root, list);
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            if (list.get(lo) != list.get(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    private void specMidTraversal(Tree root, List<Integer> list) {
        if (null == root) {
            list.add(0);
        } else {
            specMidTraversal(root.left, list);
            list.add(root.value);
            if (root.right != null) {
                specMidTraversal(root.right, list);
            }
        }
    }


    // 求二叉树最远两节点距离
    public int solution(Tree root) {
        if (null == root) {
            return 0;
        }
        int maxLeft = cal(root.left);
        int maxRight = cal(root.right);

        return maxLeft + maxRight;
    }

    public int cal(Tree root) {
        if (null == root) {
            return 0;
        }

        return Math.max(cal(root.left), cal(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeExercise exercise = new TreeExercise();


        Tree one = new Tree(null, null, 1);
        Tree two = new Tree(null, null, 2);
        Tree tree = new Tree(one, two, 3);
        Tree four = new Tree(null, null, 4);

        Tree root = new Tree(four, tree, 5);

//        System.out.println(exercise.solution(root));

        System.out.println("前序遍历: ");
        exercise.frontTraversal(root);
        System.out.println("中序遍历: ");
        exercise.midTraversal(root);
        System.out.println("后序遍历: ");
        exercise.backTraversal(root);
        System.out.println("层序遍历: ");
        exercise.floorTraversal(root);
    }
}
