/**
 * Implement a stack using linked list.
 */
import java.util.NoSuchElementException;

public class LinkedListStack {
    private class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public void push(Object data) {
        head = new Node(data, head);
        size++;
    }

    public Object pop() {
        if (head == null) {
            throw new NoSuchElementException("Cannot pop from an empty stack.");
        }
        Object popData = head.data;
        head = head.next;
        size--;
        return popData;
    }

    public Object peek() {
        if (head == null) {
            throw new NoSuchElementException("Cannot peek from an empty stack.");
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}