package leecode.linked_list;

import java.util.Arrays;

public class _19_remove_nth_node_from_end_of_list {
    //way1 遍历两边列表
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        int lenght = 0;
        ListNode cur = head;
        while (cur != null) {
            lenght++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < lenght - n - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(Arrays.asList(1));
        removeNthFromEnd1(head, 1);
    }
}
