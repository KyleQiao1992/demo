package practice;

import leecode.bt_search_tree.TreeNode;

public class _222_count_complete_tree_nodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
