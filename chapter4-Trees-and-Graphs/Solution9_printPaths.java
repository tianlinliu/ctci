/**
 * Question 4.9:
 * Given a binary tree in which each node contains a value. Design an algorithm to
 * print all paths which sum to a given value. The path does not need to start or
 * end at the root or a leaf, but it must go in a straight line down.
 */

import java.util.ArrayList;

public class Solution9_printPaths {
    /**
     * Preorder traverse the tree, if the sum of its ancestors equals to the given
     * value, print out the numbers.
     */
    public static void printPaths(Node root, int target) {
        if (root == null) {
            System.out.println("Empty tree.");
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        printPath(root, target, path, 0);
    }

    /* recursive function */
    private static void printPath(Node root, int target, ArrayList<Integer> path, int level) {
        if (root == null) return;

        path.add(level, root.value); //?

        int sum = 0;
        for (int i = level; i >= 0; i--) {
            sum += path.get(i);
            if (sum == target) {
                print(path, i, level);
            }
        }

        printPath(root.left, target, path, level + 1);
        printPath(root.right, target, path, level + 1);
    }

    private static void print(ArrayList<Integer> path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path.get(i) + " ");
        }
            System.out.println();
    }




    public static Node build() {
        return new Node(4, new Node(2, new Node(1), new Node(3)),
            new Node(6, new Node(5), new Node(7)));
    }
    public static void main(String[] args) {
        Node root = build();
        printPaths(root, 7);
    }
}