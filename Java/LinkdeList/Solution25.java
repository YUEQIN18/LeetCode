package LinkdeList;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            // 让end先走k步
            for (int i = 0; i < k && end != null; i ++) end = end.next;
            if (end == null) break; // 退出while循环
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            // 从start开始翻转
            reverse(start);
            pre.next = end;
            start.next = next;
            // 移动end指针
            end = pre = start;
        }
        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
