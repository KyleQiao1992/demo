package leecode.linked_list;

import java.util.Arrays;
import java.util.Stack;

public class _445_add_two_numbers_II {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                stack1.push(cur1.val);
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                stack2.push(cur2.val);
                cur2 = cur2.next;
            }
        }
        Stack<Integer> sumStack = new Stack<>();
        int maxLong = Math.max(stack1.size(), stack2.size());
        int carry = 0;
        for (int i = 0; i < maxLong || carry == 1; i++) {
            Integer sum1 = stack1.isEmpty() ? 0 : stack1.pop();
            Integer sum2 = stack2.isEmpty() ? 0 : stack2.pop();
            Integer sum = sum1 + sum2 + carry;
            if (sum < 10) {
                sumStack.push(sum);
                carry = 0;
            } else {
                sumStack.push(sum % 10);
                carry = 1;
            }
        }
        ListNode sumListNode = new ListNode(-1);
        ListNode cur = sumListNode;
        while (!sumStack.isEmpty()) {
            cur.next = new ListNode(sumStack.pop());
            cur = cur.next;
        }

        return sumListNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(Arrays.asList(5));
        ListNode l2 = ListNode.buildListNode(Arrays.asList(5));
        ListNode result = addTwoNumbers(l1, l2);
        int a = 0;
    }
}
