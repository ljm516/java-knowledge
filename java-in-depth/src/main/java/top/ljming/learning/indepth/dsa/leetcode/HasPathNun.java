package top.ljming.learning.indepth.dsa.leetcode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lijm
 */
public class HasPathNun {
    public static void main(String[] args) {
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode two = new TreeNode(2, null, null);
        TreeNode eleven = new TreeNode(11, seven, two);
        TreeNode leftFour = new TreeNode(4, eleven, null);
        TreeNode one = new TreeNode(1, null, null);
        TreeNode rightFour = new TreeNode(4, null, one);
        TreeNode thirdTeen = new TreeNode(13, null, null);
        TreeNode eight = new TreeNode(8, thirdTeen, rightFour);
        TreeNode root = new TreeNode(5, leftFour , eight);

        System.out.println(hasPathNum(root, 22));
    }

    private static boolean hasPathNum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathNum(root.left, sum) || hasPathNum(root.right, sum);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left =left;
            this.right = right;
        }
    }
}
