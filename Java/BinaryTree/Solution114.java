package BinaryTree;

import java.util.Stack;

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) return ;
        // 这道题指定我们前序遍历，这里使用迭代法，因为用的是栈，所以入栈顺序是右左中，这样弹出就是中左右
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        while(!s.isEmpty()) {
            TreeNode temp = s.pop();
            // 将前一个节点的right指针指向现在的节点
            if (pre != null) {
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
            pre = temp; // 更新pre节点
        }
    }
}
