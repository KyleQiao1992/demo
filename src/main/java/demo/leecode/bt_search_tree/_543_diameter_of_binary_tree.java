package demo.leecode.bt_search_tree;

public class _543_diameter_of_binary_tree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = getDepth(root.left);
        int rightLength = getDepth(root.right);
        max = Math.max(max, leftLength + rightLength);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        TreeNode node = TreeNode.constructTree(a);
        _543_diameter_of_binary_tree f = new _543_diameter_of_binary_tree();

        f.diameterOfBinaryTree(node);
    }
}
