package demo.leecode.bt_search_tree;

public class _437_path_sum_iii {

    //在以root为根节点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public static int pathSum(TreeNode root, int sum) {

        if (root == null)
            return 0;

        return findPath(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private static int findPath(TreeNode node, int num) {

        if (node == null)
            return 0;

        int res = 0;
        if (node.val == num)
            res += 1;

        res += findPath(node.left, num - node.val);
        res += findPath(node.right,   num - node.val);

        return res;
    }

    public static void main(String[] args) {

        /*****************
         * Test case:
         *
         *       10
         *      /  \
         *     5   -3
         *    / \    \
         *   3   2   11
         *  / \   \
         * 3  -2   1
         *****************/
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(-2);

        TreeNode node3 = new TreeNode(3);
        node3.left = node1;
        node3.right = node2;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node5.right = node4;

        TreeNode node6 = new TreeNode(5);
        node6.left = node3;
        node6.right = node5;

        TreeNode node7 = new TreeNode(11);
        TreeNode node8 = new TreeNode(-3);
        node8.right = node7;

        TreeNode node9 = new TreeNode(10);
        node9.left = node6;
        node9.right = node8;

        System.out.println(pathSum(node9, 8));
    }
}
