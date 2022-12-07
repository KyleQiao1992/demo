package demo.data_structure.queue;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/7/17
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
