package leecode.bt_search_tree;

import java.util.Arrays;
import java.util.List;

public class _222_count_complete_tree_nodes {
    /**
     * 方法1：自己实现的递归
     *
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNode2(root) + 1;
    }

    private static int countNode2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNode2(root.left);
        int rightCount = countNode2(root.right);
        if (root.left != null && root.right != null) {
            return leftCount + rightCount + 2;
        }
        if (root.left == null && root.right == null) {
            return leftCount + rightCount;
        } else {
            return leftCount + rightCount + 1;
        }
    }

    /**
     * 方法2：参考别人的递归
     *
     * @param root
     * @return
     */
    public int countNode3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNode3(root.left) + countNode3(root.right) + 1;
    }

    /**
     *
     * @param root
     * @return
     */
    public int countNodes4(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int) Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root)) left = pivot + 1;
            else right = pivot - 1;
        }

        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int) Math.pow(2, d) - 1 + left;
    }

    // Return tree depth in O(d) time.
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        TreeNode root = TreeNode.constructTree(a);
        int res = countNodes(root);
    }
}
