package BinaryTree;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return traversal(root, 0);
    }
    private int traversal(TreeNode root, int acc) {
        if (root == null) return 0;

        int sum = acc * 10 + root.val; // 中
        if (root.left == null && root.right == null) return sum;
        else return traversal(root.left, sum) + traversal(root.right, sum);
    }
}
