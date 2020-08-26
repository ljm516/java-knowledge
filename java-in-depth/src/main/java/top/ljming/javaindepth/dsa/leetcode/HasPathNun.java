package top.ljming.javaindepth.dsa.leetcode;

import top.ljming.javaindepth.dsa.domain.Tree;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lijm
 */
public class HasPathNun {
    public static void main(String[] args) {
        Tree seven = new Tree(null, null, 7);
        Tree two = new Tree(null, null, 2);
        Tree eleven = new Tree(seven, two, 11);
        Tree leftFour = new Tree(eleven, null, 4);
        Tree one = new Tree(null, null, 1);
        Tree rightFour = new Tree(null, one, 4);
        Tree thirdTeen = new Tree(null, null, 13);
        Tree eight = new Tree(thirdTeen, rightFour, 8);
        Tree root = new Tree(leftFour, eight, 5);

        System.out.println(hasPathNum(root, 22));
    }

    private static boolean hasPathNum(Tree root, int sum) {
        if (null == root) {
            return false;
        }
        sum -= root.value;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathNum(root.left, sum) || hasPathNum(root.right, sum);
    }
    
}
