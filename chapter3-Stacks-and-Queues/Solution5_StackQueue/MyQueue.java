/**
 * Question 3.5:
 * Implement a MyQueue class which implements a queue using two stacks.
 */
import java.util.Stack;
import java.util.NoSuchElementException;

public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void enqueue(int data) {
        s1.push(data);
    }

    public int dequeue() {
        if (s1.empty()) {
            throw new NoSuchElementException("Cannot remove from an empty queue.");
        }

        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        int data = s2.pop();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return data;
    }

    public int peek() {
        if (s1.empty()) {
            throw new NoSuchElementException("Cannot remove from an empty queue.");
        }

        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        int data = s2.peek();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return data;
    }

    public int size() {
        return s1.size();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

}