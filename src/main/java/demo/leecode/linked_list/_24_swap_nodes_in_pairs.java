package demo.leecode.linked_list;

public class _24_swap_nodes_in_pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return dummyHead.next;
    }
}