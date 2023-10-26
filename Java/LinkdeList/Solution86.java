package LinkdeList;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        // 找到第一个大于x的节点 的前一个节点left，之后的每个值都移动到left右边，left每次要更新
        ListNode dummyHead = new ListNode(-1, head);
        ListNode left = dummyHead;
        while (left.next != null && left.next.val < x) {
            left = left.next;
        }
        ListNode right = left.next;
        ListNode cur = right;
        while (cur != null && cur.next != null) {
            if (cur.next.val < x) {
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                left.next = temp;
                temp.next = right;
                left = temp;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
