package practice.data_structure;

import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public BST.Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
//    写法1；
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        }
//        add(root, e);
//    }
//
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (node.left == null && e.compareTo(node.e) < 0) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (node.right == null && e.compareTo(node.e) > 0) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else if (e.compareTo(node.e) > 0) {
//            add(node.right, e);
//        }
//    }

    public void add(E e) {
        add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contain(E e) {
        return contain(root, e);
    }

    private boolean contain(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contain(node.left, e);
        } else {
            return contain(node.right, e);
        }
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        if (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 查找最小值
     *
     * @return
     */
    public E minmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }
        return minmun(root).e;
    }

    private Node minmun(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmun(node.left);
    }

    /**
     * 查找最大值
     *
     * @return
     */
    public E maximun() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }
        return maximum(root).e;
    }

    public Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树种删除最小值所在的节点，返回最小值
     *
     * @return
     */
    public E removeMin() {
        E e = minmum();
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


}
