package demo.leecode.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _234_palindrome_linked_list {

    //使用辅助内存空间
    public static boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return false;
        }
        List<Integer> array = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            array.add(cur.val);
            cur = cur.next;
        }
        int i = 0;
        int j = array.size() - 1;
        while (i <= j) {
            if (!array.get(i).equals(array.get(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    //快慢指针
    //逆至后半部分链表
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode cur = null;
        ListNode fast = head, slow = head;
        //使用快慢指针将练链表划分成两段
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //将链表后半段逆置
        while (slow != null) {
            ListNode newNode = new ListNode(slow.val);
            if (cur == null) {
                cur = newNode;
            } else {
                newNode.next = cur;
                cur = newNode;
            }
            slow = slow.next;
        }
        //进行比较判断
        while (cur != null) {
            if (cur.val != head.val) {
                return false;
            }
            cur = cur.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        isPalindrome1(head);
        isPalindrome2(head);
    }
}
