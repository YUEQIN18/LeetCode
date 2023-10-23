package LinkdeList;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        int n = 1;
        // 走left - 1步，来到left的前一个节点
        while (n <= left - 1) {
            cur = cur.next;
            n++;
        }
        ListNode leftNode = cur;
        ListNode start = cur.next;
        // 走到right节点
        while (n <= right) {
            cur = cur.next;
            n++;
        }
        ListNode end = cur;
        ListNode rightNode = cur.next;
        // 切断链表
        leftNode.next = null;
        end.next = null;
        // 反转
        reverseLinkedList(start);
        // 拼接上
        leftNode.next = end;
        start.next = rightNode;
        return head;
    }

    private void reverseLinkedList(ListNode head){
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
