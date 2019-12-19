package leecode.linked_list;

import java.util.Arrays;

public class _19_remove_nth_node_from_end_of_list {
    //way1 遍历两边列表
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        int length = -1;
        ListNode cur = dummyHead;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = dummyHead;
        int counter = Math.max((length - n), 0);
        for (int i = 0; i < counter; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

    //way2 双指针
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode frontNode = dummyHead;
        ListNode endNode = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            endNode = endNode.next;
        }
        while (endNode != null) {
            frontNode = frontNode.next;
            endNode = endNode.next;
        }
        ListNode delNode = frontNode.next;
        frontNode.next = delNode.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(Arrays.asList(1));
//        removeNthFromEnd1(head, 2);
        removeNthFromEnd2(head, 1);
    }
}
