package data_structure.linked_list;

import data_structure.common.Node;

public class LinkedList<E> {

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //链表头添加元素
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        head = new Node(e, head);
//        size++;
        add(0, e);
    }

    //在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node<>(e, prev.next);
        size++;

    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    //修改离岸边的第index(0-based)个位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.  Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size - 1; i++) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第index(0-based)个位置的元素为e
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.  Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return (E)retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}