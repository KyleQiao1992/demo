package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_binary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;

        while (!queue.isEmpty()) {
            int newLevelNum = 0;
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.remove();
                tempList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            res.add(tempList);
            levelNum = newLevelNum;
        }
        return res;
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
            traversal.add(depth, new ArrayList<>());
        }
        traversal.get(depth).add(root.val);
        if (root.left != null) {
            levelOrderBottom2(root.left, depth + 1, traversal);
        }
        if (root.right != null) {
            levelOrderBottom2(root.right, depth + 1, traversal);
        }
    }
}
