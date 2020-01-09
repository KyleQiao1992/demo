package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.List;

public class _94_binary_tree_inorder_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法1 递归方法
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            inOrderTraversal(node.left, res);
            res.add(node.val);
            inOrderTraversal(node.right, res);
        }
    }
}
