package LinkdeList;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 这里使用了3个指针
        // pre 指向了left节点的前一个，不变
        // cur 指向了left节点，不变
        // next 指向cur节点的下一个，会在循环中变化
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i ++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return dummyHead.next;
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
