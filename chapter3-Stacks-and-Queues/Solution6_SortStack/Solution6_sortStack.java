/**
 * Question 3.6:
 * Sort a stack in ascending order(with biggest items on top). You may use at most
 * one additional stack to hold items, but you may not copy the elements into any
 * other data structure(such as an array). The stack supports the following
 * operations: push, pop, peek and isEmpty.
 */

import java.util.Stack;

public class Solution6_sortStack {
    public static Stack<Integer> sortStack(Stack<Integer> source) {
        if (source.isEmpty()) return source;

        Stack<Integer> result = new Stack<Integer>();
        while (!source.isEmpty()) {
            int temp = source.pop();
            while (!result.isEmpty() && result.peek() > temp) {
                source.push(result.pop());
            }
            result.push(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> source = new Stack<Integer>();
        for (int i = 10; i >= 0; i--) {
            source.push(i);
        }
        Stack<Integer> result = sortStack(source);
        for (int i = 0; i <= 10; i++) {
            System.out.println(result.pop());
        }
    }
}