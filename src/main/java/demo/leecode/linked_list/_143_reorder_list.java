package demo.leecode.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _143_reorder_list {
    // way1 设置数组对撞指针
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        List<Integer> array = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            array.add(cur.val);
            cur = cur.next;
        }
        int p = 0;
        int q = array.size() - 1;
        cur = head;
        cur.next = new ListNode(array.get(q));
        cur = cur.next;
        p++;
        q--;
        while (p <= q) {
            cur.next = new ListNode(array.get(p));
            cur = cur.next;
            if (p != q) {
                cur.next = new ListNode(array.get(q));
                cur = cur.next;
            }
            p++;
            q--;
        }
        cur.next = null;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(Arrays.asList(1, 2, 3, 4, 5));
        reorderList(head);
    }
}
