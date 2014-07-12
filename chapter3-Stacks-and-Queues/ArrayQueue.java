/**
 * An implementation of a queue using a fixed, non-expandable array whose
 * capacity is set in its constructor.
 */
import java.util.NoSuchElementException;

public class ArrayQueue {
    private Object[] queue;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        queue = new Object[capacity];
    }

    public void enqueue(Object item) {
        if (tail == queue.length - 1) {
            throw new IllegalStateException("Cannot add item to a full queue.");
        }
        queue[tail++] = item;
        size++;
    }

    public Object dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty queue.");
        }
        size--;
        return queue[head++];
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty queue.");
        }
        return queue[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
/*
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(4);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.dequeue();
        q.enqueue("D");
        q.dequeue();
        q.enqueue("E");
        q.enqueue("F");
    }
*/
}