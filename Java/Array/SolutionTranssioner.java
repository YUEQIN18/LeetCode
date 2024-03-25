package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinyue
 * @create 2024-03-19 14:40:00
 */
public class SolutionTranssioner {

    private List<TreeNode> list = new ArrayList<>();
    public TreeNode preOrder(TreeNode root) {
        TreeNode head = new TreeNode();
        TreeNode cur = new TreeNode();
        head.right = cur;
        if (root == null) return head.right;
        traversal(root);

        if (!list.isEmpty()) {
            for (TreeNode node : list) {
                TreeNode n = new TreeNode();
                n.val = node.val;
                cur.right = n;
                cur = cur.right;
            }
        }
        return head.right.right;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        list.add(root);
        traversal(root.left);
        traversal(root.right);
    }
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode a = new TreeNode();
        TreeNode b = new TreeNode();
        a.val = 2;
        b.val = 3;
        root.val = 10;
        root.left = a;
        root.right = b;
        SolutionTranssioner solutionTranssioner = new SolutionTranssioner();
        TreeNode res = solutionTranssioner.preOrder(root);
        if (res != null) {
            while(res != null) {
                System.out.println(res.val);
                res = res.right;
            }
        }

    }
}
