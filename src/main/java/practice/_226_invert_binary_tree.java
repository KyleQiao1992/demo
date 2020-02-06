package practice;

import leecode.bt_search_tree.TreeNode;

public class _226_invert_binary_tree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;
        return root;
    }
}
