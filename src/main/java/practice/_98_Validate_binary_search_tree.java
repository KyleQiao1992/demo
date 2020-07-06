package practice;

import leecode.bt_search_tree.TreeNode;

public class _98_Validate_binary_search_tree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min.left != null && root.val < min.val) {
            return false;
        }
        if (max.right != null && root.val > max.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
