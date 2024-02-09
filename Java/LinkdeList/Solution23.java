package LinkdeList;

/**
 * @author qinyue
 * @create 2024-02-09 19:28:00
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Solution23 {
    // 多个链表合并，可以两两合并，最后合成一个`
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) >> 1;
        return mergeTwoLists(divide(lists, l, mid), divide(lists, mid + 1, r));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) return a != null ? a : b;
        ListNode head = new ListNode(0);
        ListNode tail = head, p1 = a, p2 = b;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        // 如果2个链表合并之后还有剩下的
        tail.next = p1 != null ? p1 : p2;
        return head.next;
    }

}
