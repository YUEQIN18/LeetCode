package Sort;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Solution148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; // 单个节点无需排序
        // 使用快慢指针，寻找中间节点（涉及题目《876. 链表的中间结点》）
        ListNode s = head, f = head, ps = head; // 不为 ps 设置值 Java 编译器会报错，随便指了一个值。实际上ps不设置值，也一定不会为 null，因为 head 至少有两个节点。
        while (f != null && f.next != null) {
            f = f.next.next;
            ps = s;
            s = s.next;
        }
        // 分割链表（利用 ps，与题目《206. 反转链表》有异曲同工之处）
        ps.next = null;
        // 继续分割链表（涉及归并排序）
        var l = sortList(head);
        var r = sortList(s);
        // 合并有序链表（涉及题目《21. 合并两个有序链表》）
        return merge(l, r);
    }

    ListNode merge(ListNode l, ListNode r) {
        var dummy = new ListNode();
        var curr = dummy;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if (l == null) {
            curr.next = r;
        } else {
            curr.next = l;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
