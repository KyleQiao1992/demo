package demo.linkedList;

import demo.leecode.linked_list.ListNode;

public class no1669_mergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;

        while (l1.next != null && l2.next != null) {


            if (l1.val <= l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;

            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }

        return head;

    }
}
