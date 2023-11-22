package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Solution105 {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] preorder;
    private int[] inorder;
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, length - 1);
    }
    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int val = preorder[preIndex++];
        int index = map.get(val);

        TreeNode node = new TreeNode(val);
        node.left = build(left, index - 1);
        node.right = build(index + 1, right);

        return node;
    }

}
