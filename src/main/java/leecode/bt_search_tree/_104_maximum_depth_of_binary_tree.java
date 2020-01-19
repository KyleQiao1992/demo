package leecode.bt_search_tree;

public class _104_maximum_depth_of_binary_tree {

    //way1 递归方法
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    //way2 非递归
    public int maxDepth2(TreeNode root) {
    }
}
