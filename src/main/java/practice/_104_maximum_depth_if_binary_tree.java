package practice;

import leecode.bt_search_tree.TreeNode;

public class _104_maximum_depth_if_binary_tree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
