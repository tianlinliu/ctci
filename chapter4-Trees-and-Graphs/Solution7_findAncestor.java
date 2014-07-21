/**
 * Question 4.7:
 * Design an algorithm to find the first common ancestor of two nodes in a binary tree.
 * No additional data structure. ** This is not necessary a BST.**
 */

public class Solution7_findAncestor {
    /**
     * If m, n both are under the left subtree, go left;
     * If both are under the right subtree, go right;
     * If
     */
    public static Node findCommonAncestor(Node root, Node m, Node n) {
        if (!covers(root, m) || !covers(root, n)) return null;  //error check
        return helpler(root, m, n);
    }

    /* Returns true if m is a descendent of root */
    private static boolean covers(Node root, Node m) {
        if (root == null) return false;
        if (root == m) return true;
        return covers(root.left, m) || covers(root.right, m);
    }

    private static Node helpler(Node root, Node m, Node n) {
        if (root == null) return null;
        /* check current node */
        if (root == m || root == n) return root;

        // either on left or right
        boolean is_m_on_left = covers(root.left, m);
        boolean is_n_on_left = covers(root.left, n);
        /* if m and n are on different sides */
        if (is_m_on_left != is_n_on_left) return root;
        /* on one side, traverse this side */
        Node next = is_m_on_left ? root.left : root.right;
        return helpler(next, m, n);
    }

    /***************** For BST **********************
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