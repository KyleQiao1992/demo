package leecode.bt_search_tree;

public class _404_sum_of_left_leaves {

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        //is leaf node?
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.constructTree(a);
        int sum = sumOfLeftLeaves(root);
    }
}
