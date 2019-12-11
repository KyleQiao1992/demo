package leecode.linked_list;

import java.util.Arrays;
import java.util.Stack;

public class _2_add_two_numbers {
    @Deprecated
    //Integer超过范围
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        String str1 = "";
        String str2 = "";
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                str1 += s1.pop();
            }
            if (!s2.isEmpty()) {
                str2 += s2.pop();
            }
        }
        Long integer1 = Long.parseLong(str1);
        Long integer2 = Long.parseLong(str2);
        Long sum = integer1 + integer2;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (sum != 0) {
            if (cur == null) {
                cur = new ListNode((int) (sum % 10));
            } else {
                cur.next = new ListNode((int) (sum % 10));
                cur = cur.next;
            }
            sum = sum / 10;
        }

        return head.next == null ? head.next = new ListNode(0) : head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        Integer carryFlag = 0;
        while ((l1 != null || l2 != null) || carryFlag == 1) {
            Integer val1 = 0;
            Integer val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            Integer sum = val1 + val2 + carryFlag;
            if (sum < 10) {
                cur.next = new ListNode(sum);
                cur = cur.next;
                carryFlag = 0;
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                carryFlag = 1;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(Arrays.asList(5));
        ListNode l2 = ListNode.buildListNode(Arrays.asList(5));
        ListNode head = addTwoNumbers(l1, l2);
    }
}
