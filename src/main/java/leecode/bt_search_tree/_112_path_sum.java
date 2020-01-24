package leecode.bt_search_tree;

public class _112_path_sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //确定当前节点是叶子节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        if (hasPathSum(root.left, sum - root.val)) {
            return true;
        }

        if (hasPathSum(root.right, sum - root.val)) {
            return true;
        }

        return false;
    }
}
