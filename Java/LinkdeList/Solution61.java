package LinkdeList;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        int length = 0; // 链表的长度
        ListNode c = dummyHead.next;
        while (c != null) {
            c = c.next;
            length++;
        }
        for (int i = 0; i < k % length; i++) {
            // 找到末尾的节点
            while (pre.next != null && cur.next != null) {
                pre = pre.next;
                cur = cur.next;
            }
            // 断开倒数第二个节点
            pre.next = null;
            // 将末尾节点只想第一个节点
            cur.next = dummyHead.next;
            // 重新设置第一个节点, pre, cur
            dummyHead.next = cur;
            pre = dummyHead;
            cur = dummyHead.next;
        }
        return dummyHead.next;
    }
}
