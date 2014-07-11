/**
 * Implement a stack by extending class LinkedList.
 */
import java.util.LinkedList;

public class WrapperStack {
    private LinkedList<Object> stack;

    public WrapperStack() {
        stack = new LinkedList<Object>();
    }

    public void push(Object item) {
        stack.push(item);
    }

    public Object pop() {
        return stack.pop();
    }

    public Object peek() {
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}