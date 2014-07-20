/**
 * Question 4.7:
 * Design an algorithm to find the first common ancestor of two nodes in a binary tree.
 * No additional data structure.
 */

 public class Solution7_findAncestor {
    /**
     * If the root's value is in the range between the given nodes, then it is the first common ancestor.
     * If it's less than the smaller one, find the left subtree.
     * If it's larger than the larger one, find the right subtree.
     */
    public static Node findAncestor(Node root, Node first, Node second) {
        if (first == null || second == null) return null;

        int one = first.value;
        int two = second.value;
        if (one > two) {
            one = second.value;
            two = first.value;
        }

        while (root != null) {
            int value = root.value;
            if (value >= one && value < two) {
                return root;
            } else if (value < one) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
    /* don't need to traverse the whole tree */
 }