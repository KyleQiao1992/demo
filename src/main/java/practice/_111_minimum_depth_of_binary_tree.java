package practice;

import leecode.bt_search_tree.TreeNode;

public class _111_minimum_depth_of_binary_tree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
