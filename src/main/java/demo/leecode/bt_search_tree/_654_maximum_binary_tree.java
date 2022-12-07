package demo.leecode.bt_search_tree;

public class _654_maximum_binary_tree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int index = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);

        root.left = constructMaximumBinaryTree(nums, startIndex, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, endIndex);
        return root;
    }

}
