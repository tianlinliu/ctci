/**
 * Implement a stack class using array.
 */
import java.util.NoSuchElementException;

public class ArrayStack {
    private Object[] array;
    private int size;

    public ArrayStack(int capacity) {
        array = new Object[capacity];
    }

    public void push(Object item) {
        if (size == array.length) {
            throw new IllegalStateException("Cannot add to full stack.");
        }
        array[size++] = item;
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot pop from an empty stack.");
        }
        return array[--size];
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek from an empty stack.");
        }
        return array[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}