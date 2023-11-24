package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class Solution106 {

    private int[] postorder;
    private Map<Integer, Integer> map = new HashMap<>();

    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int length = postorder.length;
        postIndex = length - 1;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, length - 1);
    }
    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int val = postorder[postIndex--];
        int index = map.get(val);
        // 因为后序遍历是 左右中, 而我们现在遍历的顺序是 中->右->左
        TreeNode node = new TreeNode(val);
        node.right = build(index + 1, right);
        node.left = build(left, index - 1);
        return node;
    }

}
