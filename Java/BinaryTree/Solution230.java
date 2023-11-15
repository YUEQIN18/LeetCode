package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class Solution230 {
    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        traversal(root);
        return list.get(k - 1);
    }
    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
