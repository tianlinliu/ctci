import java.util.Stack;

public class StackWithMin_2 {
    /**
     * Make a wrapper around exsting Stack class to implement the stack.
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public StackWithMin_2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.empty() || minStack.peek() > value) {
            minStack.push(value);
        }
    }

    public int pop() {
        if (stack.pop() == minStack.peek()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        if (stack.empty()) {
            throw new IllegalStateException("Cannot get the minimum element from an empty stack.");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin_2 aStack = new StackWithMin_2();
        //System.out.println(aStack.pop());
        //System.out.println(aStack.min());
        aStack.push(1);
        aStack.push(2);
        System.out.println(aStack.min());
        System.out.println(aStack.pop());
    }
}