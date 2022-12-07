package demo.leecode.linked_list;

import java.util.Arrays;
import java.util.Stack;


public class _92_reverse_linked_list_II {

    //使用辅助空间
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //如果头结点只有一个元素直接返回head
        if (head.next == null || m == n) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode beginNode = null;
        ListNode endNode = null;
        //循环一次找到beginNode和endNode
        int i = 1;
        ListNode cur = head;
        Stack aux = new Stack();

        while (i <= n) {
            if (i == m - 1) {
                beginNode = cur;
            }
            if (i == n) {
                endNode = cur;
            }
            if (i <= n && i >= m) {
                aux.push(cur.val);
            }
            cur = cur.next;
            i++;
        }
        if (beginNode == null) {
            beginNode = dummyHead;
        }
        cur = beginNode;
        ListNode lastNode = null;
        while (!aux.isEmpty()) {
            ListNode node = new ListNode((int) aux.pop());
            cur.next = node;
            cur = cur.next;
            if (aux.empty()) {
                lastNode = cur;
            }
        }
        lastNode.next = endNode.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode testNodeList = ListNode.buildListNode(Arrays.asList(1, 2, 3, 4, 5));
        reverseBetween(testNodeList, 3, 4);
        ListNode.printListNode(testNodeList);
    }
}
