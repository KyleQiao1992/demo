package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.List;

public class _230_kth_smallest_element_in_a_bst {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return -1;
        }
        List<Integer> tmp = new ArrayList<>();
        inOrderTraverse(root, tmp);
        return tmp.get(k - 1);
    }

    private void inOrderTraverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrderTraverse(root.left, result);
            result.add(root.val);
            inOrderTraverse(root.right, result);
        }
    }

    public static void main(String[] args) {
        Integer[] res = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = TreeNode.constructTree(res);
        _230_kth_smallest_element_in_a_bst a = new _230_kth_smallest_element_in_a_bst();
        int result = a.kthSmallest(root, 3);
    }
}
