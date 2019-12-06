package leecode.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _92_reverse_linked_list_II {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //如果头结点只有一个元素直接返回head
        if (head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode beginNode = null;
        ListNode endNode = null;
        //循环一次找到beginNode和endNode
        int i = 1;
        ListNode cur = head;
        while (i <= n) {
            if (i == m) {
                beginNode = cur;
            }
            if (i == n) {
                endNode = cur;
            }
            cur = cur.next;
            i++;
        }

        ListNode pre = null;
        cur = beginNode;
        while (cur != null && endNode != null && cur != endNode.next) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            if (cur != endNode) {
                cur = next;
            }
        }
        head.next = cur;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode testNodeList = ListNode.buildListNode(Arrays.asList(1, 2, 3, 4, 5));
        reverseBetween(testNodeList, 2, 4);
        ListNode.printListNode(testNodeList);
    }
}
