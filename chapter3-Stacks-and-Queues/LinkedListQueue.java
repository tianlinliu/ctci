/**
 * An implementation of a queue using singly linked nodes.  The
 * queue itself maintains links to both the head and the tail
 * node, so that both enqueuing and dequeueing are O(1).
 */
import java.util.NoSuchElementException;

public class LinkedListQueue {
    private class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void enqueue(Object item) {
        Node node = new Node(item);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public Object dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty queue.");
        }
        Object item = head.value;
        if (size == 1) { // head = tail
            tail = null;
        }
        head = head.next;
        size--;
        return item;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty queue.");
        }
        return head.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}