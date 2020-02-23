package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.List;

public class _257_binary_tree_paths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (String s : leftPaths) {
            String sb = Integer.toString(root.val) + "->" + s;
            res.add(sb);
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (String s : rightPaths) {
            String sb = Integer.toString(root.val) + "->" + s;
            res.add(sb);
        }
        return res;
    }
}
