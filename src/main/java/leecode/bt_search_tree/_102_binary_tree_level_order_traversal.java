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
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.remove();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            res.add(levelList);
            levelNum = newLevelNum;
        }
        return res;
    }
}
