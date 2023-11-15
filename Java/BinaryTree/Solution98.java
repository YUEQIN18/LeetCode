package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution98 {
    private List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        Integer pre = null;
        for (Integer n : list) {
            if (pre != null && n <= pre) return false;
            pre = n;
        }
        return true;
    }
    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
