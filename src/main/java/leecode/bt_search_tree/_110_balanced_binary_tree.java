package leecode.bt_search_tree;

public class _110_balanced_binary_tree {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 2) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode root = TreeNode.constructTree(nums);
        isBalanced(root);
    }
}
