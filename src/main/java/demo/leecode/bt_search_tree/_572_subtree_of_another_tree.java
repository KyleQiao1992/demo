package demo.leecode.bt_search_tree;

public class _572_subtree_of_another_tree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return dfs(s, t)
                || isSubtree(s.left, t)
                || isSubtree(s.right, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (t.val != s.val) return false;
        return dfs(s.left, t.left)
                && dfs(s.right, t.right);
    }
}
