package top.ljming.javaindepth.dsa.leetcode;

import top.ljming.javaindepth.dsa.domain.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode第230题：给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第k个最小的元素。
 * 说明：你可以假设k总是有效的，1≤k≤二叉搜索树元素个....
 *
 * @author lijm
 */
public class KthSmallestInSearchTree_230 {


    public int kthSmallest(Tree root, int k) {
        List<Integer> nums = order(root, new ArrayList<>());
        return nums.get(k - 1);
    }

    private List<Integer> order(Tree root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }
        order(root.left, arr);
        arr.add(root.value);
        order(root.right, arr);

        return arr;
    }

}
