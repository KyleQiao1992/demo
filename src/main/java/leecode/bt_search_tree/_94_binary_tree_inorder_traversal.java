package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_binary_tree_inorder_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法1 递归方法
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            inOrderTraversal(node.left, res);
            res.add(node.val);
            inOrderTraversal(node.right, res);
        }
    }

    /**
     * 方法2 模拟系统栈方法的非递归算法
     */
    private class Command {
        String cmd;
        TreeNode treeNode;

        public Command(String cmd, TreeNode treeNode) {
            this.cmd = cmd;
            this.treeNode = treeNode;
        }
    }

    public List<Integer> inOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command cmd = stack.pop();
            if ("print".equals(cmd.cmd)) {
                res.add(cmd.treeNode.val);
            } else {
                if (cmd.treeNode.right != null) {
                    stack.push(new Command("go", cmd.treeNode.right));
                }
                stack.push(new Command("print", cmd.treeNode));
                if (cmd.treeNode.left != null) {
                    stack.push(new Command("go", cmd.treeNode.left));
                }
            }
        }
        return res;
    }
}
