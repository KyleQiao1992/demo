package demo.leecode.linked_list;

import java.util.Arrays;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode buildListNode(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return new ListNode(list.get(0));
        }
        ListNode head = new ListNode(list.get(0));
        ListNode cur = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode listNode = new ListNode(list.get(i));
            cur.next = listNode;
            cur = cur.next;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print("|" + cur.val + "|->");
            cur = cur.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6);
        ListNode head = buildListNode(testList);
        printListNode(head);
    }
}
