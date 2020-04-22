package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _98_validate_binary_search_tree {
    /**
     *  注意这种写法是错误的,因为二分搜索树的定义为：二分搜索树的每个节点大于其左子树的所有节点的值，小于其右子树所有节点的值
     *         10
     *        /  \
     *       5   15
     *          / \
     *         6  20
     *  很显然6小于10不满足
     * @param root
     * @return
     */
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left != null && root.left.val >= root.val) {
//            return false;
//        }
//        if (root.right != null && root.right.val <= root.val) {
//            return false;
//        }
//
//        return isValidBST(root.left) && isValidBST(root.right);
//    }

    /**
     * 正确的解法
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    /**
     * 中序遍历方法
     *
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i + 1 < list.size(); i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static void inOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            inOrder(treeNode.left, list);
            list.add(treeNode.val);
            inOrder(treeNode.right, list);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {1, 1};
        TreeNode treeNode = TreeNode.constructTree(list);
        boolean result = isValidBST2(treeNode);
    }
}
