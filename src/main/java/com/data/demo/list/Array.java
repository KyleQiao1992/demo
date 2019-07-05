package com.data.demo.list;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/7/3
 */
public class Array {
    int[] data;
    int size;

    public Array(int capacity) {
        data = new int[capacity];
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

    public void addFirst(int e) throws IllegalAccessException {
        add(0, e);
    }

    public void addLast(int e) throws IllegalAccessException {
        add(size, e);
    }

    //第index元素插入新元素e
    public void add(int index, int e) throws IllegalAccessException {
        if (size == data.length) {
            throw new IllegalAccessException("fail");
        }
        if (index < 0 || index > size) {
            throw new IllegalAccessException("fail");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    int get(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("fail");
        }
        return data[index];
    }

    void set(int index, int e) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("fail");
        }
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
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
}
