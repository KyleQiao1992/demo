package leecode.linked_list;

import java.util.Arrays;

public class _237_delete_node_in_a_linked_list {

    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            node = null;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
