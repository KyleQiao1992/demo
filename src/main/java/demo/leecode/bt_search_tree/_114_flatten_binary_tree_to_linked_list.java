package demo.leecode.bt_search_tree;

public class _114_flatten_binary_tree_to_linked_list {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

        flatten(root.left);
        flatten(root.right);
    }
}
