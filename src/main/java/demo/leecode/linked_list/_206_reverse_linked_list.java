package demo.leecode.linked_list;


public class _206_reverse_linked_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = head.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
