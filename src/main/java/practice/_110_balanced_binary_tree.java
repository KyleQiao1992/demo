package practice;

import leecode.bt_search_tree.TreeNode;

public class _110_balanced_binary_tree {

    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftNodeDepth = getDepth(root.left);
        int rightNodeDepth = getDepth(root.right);
        if (Math.abs(leftNodeDepth - rightNodeDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //获取最大深度
    private static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode node = TreeNode.constructTree(a);
        isBalanced(node);
    }
}
