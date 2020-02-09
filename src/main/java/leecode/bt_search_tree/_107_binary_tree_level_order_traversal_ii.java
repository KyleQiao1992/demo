package leecode.bt_search_tree;

import java.util.*;

public class _107_binary_tree_level_order_traversal_ii {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNodeCount = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int tmpCount = 0;
            for (int i = 0; i < levelNodeCount; i++) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    tmpCount++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    tmpCount++;
                }
            }
            stack.push(temp);
            levelNodeCount = tmpCount;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }


    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> levelOrderBottom = new ArrayList<>();
        if (root != null) {
            levelOrderBottom2(root, 0, levelOrderBottom);
        }
        return levelOrderBottom;
    }

    private static void levelOrderBottom2(TreeNode root, int depth, List<List<Integer>> traversal) {
        if (depth == traversal.size()) {
            traversal.add(0, new ArrayList<>());
        }
        traversal.get(traversal.size() - depth - 1).add(root.val);
        if (root.left != null) {
            levelOrderBottom2(root.left, depth + 1, traversal);
        }
        if (root.right != null) {
            levelOrderBottom2(root.right, depth + 1, traversal);
        }
    }

    public static void main(String[] args) {
        Integer[] nodes = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.constructTree(nodes);
        List<List<Integer>> list = levelOrderBottom2(treeNode);
    }
}
