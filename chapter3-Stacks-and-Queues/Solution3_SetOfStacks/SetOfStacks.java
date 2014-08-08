/**
 * Question 3.:
 * Implement a data structure SetOfStacks that composed of several stacks and should
 * create a new stack once the previous one exceeds capacity.
 *
 * FOLLOW UP: ? -> to much codes
 * Implement a function popAt(int index) which performs a pop operation on a
 * specific substack.
 */
import java.util.Stack;
import java.util.ArrayList;

public class SetOfStacks {
    /**
     *
     */
    private ArrayList<Stack<Integer>> stacks;
    private int capacity;

    public SetOfStacks(int capacity) {
        stacks = new ArrayList<Stack<Integer>>();
        this.capacity = capacity;
    }

    public void push(int value) {
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == capacity) {
            stacks.add(new Stack<Integer>());
        }
        stacks.get(stacks.size() - 1).push(value);
    }

    public int pop() {
        if (stacks.isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        int value = stacks.get(stacks.size() - 1).pop();
        if (stacks.get(stacks.size() - 1).empty()) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    public static void main(String[] args) {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i <= 34; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}