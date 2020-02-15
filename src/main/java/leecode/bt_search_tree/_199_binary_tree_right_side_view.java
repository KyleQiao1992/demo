package leecode.bt_search_tree;

import java.util.*;

public class _199_binary_tree_right_side_view {

    /**
     * way1 自己实现的方法，层序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelOrderList = levelOrderBT(root);
        List<Integer> res = new ArrayList<>();
        if (levelOrderList.size() == 0) {
            return res;
        }
        for (List<Integer> list : levelOrderList) {
            res.add(list.get(list.size() - 1));
        }
        return res;
    }

    private List<List<Integer>> levelOrderBT(TreeNode node) {
        List<List<Integer>> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int levelNum = 1;
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < levelNum; i++) {
                TreeNode node1 = queue.remove();
                tempList.add(node1.val);
                if (node1.left != null) {
                    queue.add(node1.left);
                    count++;
                }
                if (node1.right != null) {
                    queue.add(node1.right);
                    count++;
                }
            }
            levelNum = count;
            res.add(tempList);
        }
        return res;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        bfs(root, 0, map);
        return new ArrayList<>(map.values());
    }

    void bfs(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        bfs(root.left, level + 1, map);
        map.put(level, root.val);
        bfs(root.right, level + 1, map);
    }

    public static void main(String[] args) {
        Integer[] list = {1, 2, 3, 4, 5, 6, 7};
        TreeNode node = TreeNode.constructTree(list);
        _199_binary_tree_right_side_view a = new _199_binary_tree_right_side_view();
        List<Integer> list2 = a.rightSideView2(node);
    }
}
