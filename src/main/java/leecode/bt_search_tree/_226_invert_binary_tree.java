package leecode.bt_search_tree;

public class _226_invert_binary_tree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        } else {
            if (root.left != null) {
                invertTree(root.left);
            }
            if (root.right != null) {
                invertTree(root.right);
            }
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {

        if (root == null)
            return null;

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
