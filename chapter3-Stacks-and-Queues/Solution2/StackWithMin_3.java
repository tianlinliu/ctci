import java.util.Stack;

public class StackWithMin_3 extends Stack<Integer> {
    /**
     * Make a wrapper around exsting Stack class to implement the stack.
     */
    private Stack<Integer> minStack;

    public StackWithMin_3() {
        minStack = new Stack<Integer>();
    }

    public void push(int value) {
        super.push(value);
        if (minStack.empty() || value < min()) {
            minStack.push(value);
        }
    }

    public Integer pop() {
        int popValue = super.pop();
        if (popValue == minStack.peek()) {
            minStack.pop();
        }
        return popValue;
    }

    public int min() {
        if (super.empty()) {
            throw new IllegalStateException("Cannot get the minimum element from an empty stack.");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin_3 stack = new StackWithMin_3();
        //System.out.println(stack.pop());
        //System.out.println(stack.min());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
    }
}