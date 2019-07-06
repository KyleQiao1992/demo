package com.data.demo.list;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/7/3
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) throws IllegalAccessException {
        add(0, e);
    }

    public void addLast(E e) throws IllegalAccessException {
        add(size, e);
    }

    //第index元素插入新元素e
    public void add(int index, E e) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("fail");
        }
        if (size == data.length) {
            resize(2 * size);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("fail");
        }
        return data[index];
    }

    void set(int index, E e) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("fail");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public E remove(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("fail");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//loitering objects != memory leak
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() throws IllegalAccessException {
        return remove(0);
    }

    private E removeLast() throws IllegalAccessException {
        return remove(size - 1);
    }

    public void removeElement(E e) throws IllegalAccessException {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size=%d ,capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
