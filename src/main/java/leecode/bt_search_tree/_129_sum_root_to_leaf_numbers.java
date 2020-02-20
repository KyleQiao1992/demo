package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.List;

public class _129_sum_root_to_leaf_numbers {
    /**
     * 方法1 参考leetcode-237题的list解法
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        List<String> list = sumNumbersList(root);
        for (String str : list) {
            res += Integer.parseInt(str);
        }
        return res;
    }

    private List<String> sumNumbersList(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        List<String> left = sumNumbersList(root.left);
        for (String str : left) {
            String value = String.valueOf(root.val) + str;
            result.add(value);
        }
        List<String> right = sumNumbersList(root.right);
        for (String str : right) {
            String value = String.valueOf(root.val) + str;
            result.add(value);
        }
        return result;
    }

    private static Integer sumResult = 0;

    /**
     * 方法2 递归方式
     *
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sumResult;
    }

    private void dfs(TreeNode node, int tnum) {
        tnum = tnum * 10 + node.val;
        if (node.left == null && node.right == null) {
            sumResult += tnum + node.val;
        }
        if (node.left != null) {
            dfs(node.left, tnum);
        }
        if (node.right != null) {
            dfs(node.right, tnum);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {4, 9, 0, 5, 1};
        TreeNode node = TreeNode.constructTree(list);
        _129_sum_root_to_leaf_numbers a = new _129_sum_root_to_leaf_numbers();
        a.sumNumbers2(node);
    }
}