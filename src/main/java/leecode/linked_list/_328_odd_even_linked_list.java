package leecode.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _328_odd_even_linked_list {
    //using auxiliary space
    public static ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        ListNode cur = head;
        int j = 0;
        while (cur != null) {
            if (j % 2 == 1) {
                evenList.add(cur.val);
            } else {
                oddList.add(cur.val);
            }
            j++;
            cur = cur.next;
        }
        cur = dummyHead;
        for (int i = 0; i < oddList.size() + evenList.size(); i++) {
            if (i <= oddList.size() - 1) {
                cur.next = new ListNode(oddList.get(i));
            } else {
                cur.next = new ListNode(evenList.get(i - oddList.size()));
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static ListNode oddEvenList2(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode testNode = ListNode.buildListNode(Arrays.asList(2, 1, 3, 5, 6, 4, 7));
        oddEvenList1(testNode);
    }
}
