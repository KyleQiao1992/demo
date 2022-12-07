package demo.practice;

import demo.leecode.bt_search_tree.TreeNode;

public class _108_convert_sorted_array_to_binary_tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = dfs(nums, begin, mid - 1);
        midNode.right = dfs(nums, mid + 1, end);
        return midNode;
    }
}
