package demo.data_structure.binary_tree;


public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();
}

