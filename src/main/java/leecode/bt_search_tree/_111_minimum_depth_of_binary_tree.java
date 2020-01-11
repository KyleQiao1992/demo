package leecode.bt_search_tree;

public class _111_minimum_depth_of_binary_tree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        if (root.left != null) {
            int leftMinDepth = minDepth(root.left);
            res = Math.min(res, 1 + leftMinDepth);
        }
        if (root.right != null) {
            int rightMinDepth = minDepth(root.right);
            res = Math.min(res, 1 + rightMinDepth);
        }

        return res;
    }
}
