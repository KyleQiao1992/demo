package leecode.linked_list;

import java.util.Arrays;

public class _86_partition_list {

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lessThanNodeHead = new ListNode(-1);
        ListNode p1 = lessThanNodeHead;
        ListNode moreThanNodeHead = new ListNode(-1);
        ListNode p2 = moreThanNodeHead;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                p1.next = new ListNode(cur.val);
                p1 = p1.next;
            } else {
                p2.next = new ListNode(cur.val);
                p2 = p2.next;
            }
            cur = cur.next;
        }
        p1.next = moreThanNodeHead.next;

        return lessThanNodeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode result = partition(head, 3);
    }
}
