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

    public static void main(String[] args) {
        Integer[] nodes = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.constructTree(nodes);
        List<List<Integer>> list = levelOrderBottom(treeNode);
    }
}
