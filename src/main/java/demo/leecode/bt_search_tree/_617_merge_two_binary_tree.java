package demo.leecode.bt_search_tree;

public class _617_merge_two_binary_tree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }


    public static void main(String[] args) {
        Integer[] a1 = {1, 3, 2, 5};
        Integer[] a2 = {2, 1, 3, null, 4, null, 7};
        TreeNode node1 = TreeNode.constructTree(a1);
        TreeNode node2 = TreeNode.constructTree(a2);
        _617_merge_two_binary_tree f = new _617_merge_two_binary_tree();
        TreeNode node = f.mergeTrees(node1, node2);
    }
}
