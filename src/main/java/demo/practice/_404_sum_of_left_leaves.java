package demo.practice;

import demo.leecode.bt_search_tree.TreeNode;

public class _404_sum_of_left_leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.constructTree(nums);
        _404_sum_of_left_leaves a = new _404_sum_of_left_leaves();
        int result = a.sumOfLeftLeaves(treeNode);
    }
}
