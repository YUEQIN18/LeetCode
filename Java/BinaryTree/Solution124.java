package BinaryTree;

/**
 * 124. 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Solution124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxValue(root);
        return max;
    }

    private int getMaxValue(TreeNode root) {
        if (root == null) return 0;
        // 先计算左子树的最大贡献值
        int leftMax = Math.max(getMaxValue(root.left), 0);
        // 右子树的最大贡献值
        int rightMax = Math.max(getMaxValue(root.right), 0);
        // 包含这个节点在内的，最大路径和
        int pathMax = root.val + leftMax + rightMax;
        // 更新最大值
        max = Math.max(max, pathMax);
        // 返回包含这个节点在内的最大贡献值
        return root.val + Math.max(leftMax, rightMax);
    }

}
