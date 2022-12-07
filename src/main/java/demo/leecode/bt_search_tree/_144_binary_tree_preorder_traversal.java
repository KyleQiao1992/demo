package demo.leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_binary_tree_preorder_traversal {

    /**
     * 方法1 常规递归方式
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        preOrderTraversal(root, res);
        return res;
    }

    private void preOrderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preOrderTraversal(node.left, list);
            preOrderTraversal(node.right, list);
        }
    }

    /**
     * 方法2： 非递归的方式实现前序遍历
     */
    private class Command {
        String s;   // go, print
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preOrderTraversal2(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();

            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                assert command.s.equals("go");
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    //way3: 传统前序遍历方式
    public List<Integer> preOrderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
