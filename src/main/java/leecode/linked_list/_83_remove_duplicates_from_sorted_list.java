package leecode.linked_list;

import java.util.Arrays;

public class _83_remove_duplicates_from_sorted_list {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] arg) {
        ListNode testNode = ListNode.buildListNode(Arrays.asList(1));
        ListNode.printListNode(testNode);
        deleteDuplicates(testNode);
        ListNode.printListNode(testNode);
    }
}
