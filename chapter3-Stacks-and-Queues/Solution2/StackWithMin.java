/**
 * Question 3.2:
 * Design a stack, which has push, pop and min function return the minimum element.
 * All methods operate in O(1) time.
 */
import java.util.Stack;

public class StackWithMin {
    /**
     * Use a stack to store the minimum value.
     */
    private class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node top;
    private Stack<Integer> minStack;

    public StackWithMin() {
        minStack = new Stack<Integer>();
    }

    public void push(int value) {
        top = new Node(value, top);
        if (minStack.empty() || minStack.peek() > value) {
            minStack.push(value);
        }
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        int popValue = top.value;
        top = top.next;
        if (popValue == minStack.peek()) {
            minStack.pop();
        }
        return popValue;
    }

    public int min() {
        if (top == null) {
            throw new IllegalStateException("Cannot get the minimum element from an empty stack.");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        //System.out.println(stack.pop());
        //System.out.println(stack.min());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
    }
}