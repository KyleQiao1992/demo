package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145_binary_tree_postorder_traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //way1 递归 后序遍历二叉树
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(root, res);
        return res;
    }

    private void postOrderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            postOrderTraversal(node.left, res);
            postOrderTraversal(node.right, res);
            res.add(node.val);
        }
    }

    //方法2 模拟递归栈的实现
    private class Command {
        String s;   // go, print
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while (!stack.empty()) {
            Command command = stack.pop();

            if (command.s.equals("print"))
                res.add(command.node.val);
            else {
                assert command.s.equals("go");
                stack.push(new Command("print", command.node));
                if (command.node.right != null)
                    stack.push(new Command("go", command.node.right));
                if (command.node.left != null)
                    stack.push(new Command("go", command.node.left));
            }
        }
        return res;
    }
}
